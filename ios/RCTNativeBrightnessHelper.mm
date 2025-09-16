#import "RCTNativeBrightnessHelper.h"
#import <UIKit/UIKit.h>

@implementation RCTNativeBrightnessHelper

// moduleName must match what you used in JS spec & codegenConfig
+ (NSString *)moduleName {
  return @"NativeBrightnessHelper";
}



- (void)setBrightness:(double)brightnessLevel {
  double clamped = brightnessLevel;
  if (clamped < 0.0) clamped = 0.0;
  if (clamped > 1.0) clamped = 1.0;

  dispatch_async(dispatch_get_main_queue(), ^{
    UIScreen.mainScreen.brightness = clamped;
  });
}

- (double)getBrightness {
  return UIScreen.mainScreen.brightness;
}

@end
