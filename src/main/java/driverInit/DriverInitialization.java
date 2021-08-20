package driverInit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.BasePage;

public class DriverInitialization {
	public static IOSDriver driver;
	
	public static BasePage Base = null;
	@Before
	public static void driverInit() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "14.5");
		capabilities.setCapability("deviceName", "iPhone 12 Pro Max");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("app", "/Users/sarputheen/Downloads/Challenge/Mobile_Test/src/main/resources/appfile/TestingChallenge.app");
//		capabilities.setCapability("udid", "E28FD2B5-4D3B-4B14-80A0-490C6C2D685D");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("useNewWDA", true);
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Base = new BasePage(driver);
		
	}
	
	
	@After
	public static void teardown() {
		driver.quit();
		
	}
	
	
	
}
