import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';
import type { Float } from 'react-native/Libraries/Types/CodegenTypes';

export interface Spec extends TurboModule {
  setBrightness(value: Float): Promise<void>;
  getBrightness(): Promise<Float>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('NativeBrightnessHelper');
