package pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverInit.DriverInitialization;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
	
	
	public static WebDriver driver ;
	static String waitstrategy = "Visible";

	public BasePage(IOSDriver driver2) {
		
		 this.driver = driver2;
	}

	public static void clickOn(By by) {

		WebElement element = performExplicitWait(waitstrategy, by);
		element.click();

	}
	
	public static void click(By by) {
		try {
		
		WebElement element = performExplicitWait("None", by);
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click();
		action.perform();
		}
		catch(StaleElementReferenceException e) {
			
			click(by);
		}

	}

	public static boolean isElementDisplayed(By by) {
		boolean flag = false;

		WebElement element = performExplicitWait(waitstrategy, by);
		if (element.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
	public static boolean isElementEnabled(By by) {
		boolean flag = false;

		WebElement element = performExplicitWait(waitstrategy, by);
		if (element.isEnabled()) {
			flag = true;
		}
		return flag;
	}

	public static String getTextOn(By by) {

		WebElement element = performExplicitWait(waitstrategy, by);

		return element.getText();

	}

	public static void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	public static int getNumOfElements(By by) {
		List<WebElement> ele = driver.findElements(by);
		int i = ele.size();
		return i;
	}

	public static List<WebElement> listOfElements(By by) {
		List<WebElement> ele = driver.findElements(by);
		return ele;
	}

	public static WebElement findElement(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}

//		public static void customWait(By by, int minutes, int seconds, String text) {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		.withTimeout(Duration.ofMinutes(minutes))
//		.pollingEvery(Duration.ofSeconds(seconds))
//		.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
//		wait.until(new Function<WebDriver, WebElement>() {
//		// customized condition for fluent wait
//		public WebElement apply(WebDriver driver) {
//		WebElement ele = driver.findElement(by);
//		if (ele.getText().equalsIgnoreCase(text)) {
//		
//		return ele;
//		} else {
//		return null;
//		}
//		}
//		});
//		
//		}

	public static void moveToObjectElement(By by) {
		driver.switchTo().frame(driver.findElement(by));

	}

	public static void moveToObjectElement(String elementname) {
		driver.switchTo().frame(elementname);

	}

	public static void moveToObjectElement(int index) {
		driver.switchTo().frame(index);

	}

	public static void moveToParentPage() {
		driver.switchTo().parentFrame();

	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static WebElement performExplicitWait(String waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy.equalsIgnoreCase("Clickable")) {
			element = new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy.equalsIgnoreCase("Visible")) {
			element = new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitstrategy.equalsIgnoreCase("None")) {
		element = driver.findElement(by);
		}
		return element;
	}

	public static void switchToWebView() {
		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		((AppiumDriver) driver).context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

	}

	public static void switchToNativeApp() {
		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		((AppiumDriver) driver).context("NATIVE_APP");
	}

}
