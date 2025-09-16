package com.brightnesshelper

import android.provider.Settings
import com.brightnesshelper.NativeBrightnessHelperSpec
import com.facebook.react.bridge.ReactApplicationContext

class BrightnessHelperModule(
  reactContext: ReactApplicationContext
) : NativeBrightnessHelperSpec(reactContext) {

  override fun getName() = NAME

  override fun setBrightness(brightnessLevel: Double) {
    val activity = reactApplicationContext.currentActivity ?: return
    val clampedBrightnessLevel = brightnessLevel.coerceIn(0.0, 1.0)
  
    activity.runOnUiThread {
      try {
        val layoutParams = activity.window.attributes
        layoutParams.screenBrightness = clampedBrightnessLevel.toFloat()
        activity.window.attributes = layoutParams
      } catch (e: Exception) {
        throw e
      }
    }
  }

  override fun getBrightness(): Double {
    return try {
      val brightnessLevel = Settings.System.getInt(
        reactApplicationContext.contentResolver,
        Settings.System.SCREEN_BRIGHTNESS
      )
      brightnessLevel / 255.0
    } catch (e: Exception) {
      // Throwing here will reject the promise automatically in JS
      throw e
    }
  }

  companion object {
    const val NAME = "NativeBrightnessHelper"
  }
}
