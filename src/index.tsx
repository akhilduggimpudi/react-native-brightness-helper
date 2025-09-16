import { Platform } from 'react-native';
import type { Float } from 'react-native/Libraries/Types/CodegenTypes';
import NativeBrightnessHelper from './specs/NativeBrightnessHelper';

const LINKING_ERROR =
  `The package 'react-native-brightness-helper' doesn't seem to be linked. Make sure:\n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

if (!NativeBrightnessHelper) {
  throw new Error(LINKING_ERROR);
}

export async function setBrightness(brightnessLevel: Float) {
  return NativeBrightnessHelper.setBrightness(brightnessLevel);
}

export async function getBrightness(): Promise<Float> {
  return NativeBrightnessHelper.getBrightness();
}
