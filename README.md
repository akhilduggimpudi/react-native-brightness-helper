# react-native-brightness-helper

A React Native library to **get and set device brightness**, now supporting the **New Architecture (TurboModules)**.

---

## Installation

```sh
npm install react-native-brightness-helper
# or
yarn add react-native-brightness-helper

cd ios
pod install

## Usage


```js
import BrightnessHelper, { setBrightness, getBrightness } from 'react-native-brightness-helper';

// Set brightness (value between 0 and 1)
await setBrightness(0.5);

// Get current brightness
const currentBrightness = await getBrightness();
console.log('Current brightness:', currentBrightness);
```


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
