package com.brightnesshelper

import android.provider.Settings
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class BrightnessHelperModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {


    override fun getName(): String {
        return NAME
    }

    @ReactMethod
    fun setBrightness(brightnessLevel: Double, promise: Promise) {
        try {
            val activity = currentActivity ?: return
            val clampedBrightnessLevel = brightnessLevel.coerceIn(0.0, 1.0)

            activity.runOnUiThread {
                try {
                    val layoutParams = activity.window.attributes
                    layoutParams.screenBrightness = clampedBrightnessLevel.toFloat()
                    activity.window.attributes = layoutParams
                    
                    promise.resolve(true)
                } catch (e: Exception) {
                    promise.reject("Failed to set brightness", e)
                }
            }
        } catch (e: Exception) {
            promise.reject("Exception occurred", e)
        }
    }

    @ReactMethod
    fun getBrightness(promise: Promise) {
        try {
            val brightnessLevel = Settings.System.getInt(
                reactApplicationContext.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS
            )
            val convertedBrightnessLevel = brightnessLevel / 255.0
            promise.resolve(convertedBrightnessLevel)
        } catch (e: Settings.SettingNotFoundException) {
            promise.reject("Failed to get Settings", e)
        } catch (e: Exception) {
            promise.reject("Unknown Error", e)
        }
    }

    companion object {
        const val NAME = "BrightnessHelper"
    }
}
