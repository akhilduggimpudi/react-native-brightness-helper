import { useState, useEffect } from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { getBrightness, setBrightness } from 'react-native-brightness-helper';

export default function App() {
  const [brightnessLevel, setBrightnessLevel] = useState<number | undefined>();

  useEffect(() => {
    const screenBrightness = async () => {
      const screenBrightnessLevel = await getBrightness();
      setBrightnessLevel(screenBrightnessLevel);
      if (screenBrightnessLevel < 0.5) {
        await setBrightness(0.6);
      }
    };

    screenBrightness();
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {brightnessLevel}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
