# Blinkist_Assesment

Small POC for Mobile Application Auotmation

## Tech stack Used
Java, Cucumber, Appium, Extent Report


## Prerequisites 
    Mac OS
    Xcode 
    Appium and WebDriverAgent configuration should be setup already.
    Java 8 and above 
    Any IDE 
    

## Note:  
          As I have got the source code of both IOS and Android builds, I have built the TestingChallenge.app file using Xcode and ran it using the Xcode simulators.If this needs to be executed on real IOS device please use the application with .ipa extension. 


## Project Setup 
- Driver capabilities -  \src\test\java\driverInit\
- Page Obejcts -  \src\test\java\pageObjects\
- Application TestingChallenge.app - \src\main\resources\appfile\
- Test Runner  - \src\test\java\mobileAppRunner
- Step Definitions - \src\test\java\stepDefinitions
- Feature files - \src\test\resources\FeatureFile
- Extent Report Properties  - \src\test\resources\
- Test Report - \reports





## Steps
- Download and Extract this project to your local 
- Import as a Maven project in IDE ( Prefered - Eclipse)
- Open TestRunner.java file, from "\src\test\java\mobileAppRunner"
- Now run as JUnit Test (Make sure to run in JUnit 4)


## Approach 
    I have used the Page Object Model design pattern for this framework design. So that we can add new or remove old features if required. Also I have covered the core functionalities of both "Book List" and "You Tube Video Play".
 
## Next step of Framework Implementation
- As for now this framework will work only on IOS devices. If this needs to be supported for both IOS and Android we can use the json for capability changes and based on the OS environment provided in the capabilities json file we can create the driver instance and also we need to create the two classes to pick the web elements ex: "public class IosLocators"  and "public class AndroidLocators" . 
- Parallel testing also can be added in this framework using TestNG
    
  

















