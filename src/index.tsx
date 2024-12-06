import { NativeModules, Platform } from 'react-native';
import type { Float } from 'react-native/Libraries/Types/CodegenTypes';

const LINKING_ERROR =
  `The package 'react-native-brightness-helper' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const BrightnessHelper = NativeModules.BrightnessHelper
  ? NativeModules.BrightnessHelper
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export async function setBrightness(brightnessLevel: Float) {
  return await BrightnessHelper.setBrightness(brightnessLevel);
}

export async function getBrightness() {
  return await BrightnessHelper.getBrightness();
}
