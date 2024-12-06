import Foundation
import UIKit

@objc(BrightnessHelper)
class BrightnessHelper: NSObject {
  
  @objc
  func setBrightness (_ brightnessLevel: CGFloat, resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) {
    guard brightnessLevel >= 0 && brightnessLevel <= 1 else {
      reject("INVALID_BRIGHTNESS_LEVEL", "Brightness Level must be between 0 and 1", nil)
      return
    }
    
    DispatchQueue.main.async {
      UIScreen.main.brightness = brightnessLevel
    }
    resolve(true)
  }
  
  @objc
  func getBrightness (_ resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) {
    let brightness = UIScreen.main.brightness
      
    resolve(brightness)
  }
  
}
