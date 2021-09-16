package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class BookList extends BasePage {

	public BookList(AppiumDriver driver2) {
		super(driver2);
	}

	private static By youTubeLink = By.xpath("//XCUIElementTypeButton[@name='YouTube']");
	private static By headerText = By.xpath("//XCUIElementTypeStaticText[@name='Blinkist Code Challenge']");
	private static By bookList = By.xpath(
			"//XCUIElementTypeApplication[@name='TestingChallenge']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell");
	private static By bookImage = By.xpath(
			"//XCUIElementTypeApplication[@name='TestingChallenge']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeImage");
	private static By bookName = By.xpath(
			"//XCUIElementTypeApplication[@name='TestingChallenge']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]");
	private static By bookAuthorName = By.xpath(
			"//XCUIElementTypeApplication[@name='TestingChallenge']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]");
	private static By alertPopupText = By
			.xpath("//XCUIElementTypeStaticText[@name='You clicked on the Eat, Move, Sleep book']");
	private static By alertOK = By.xpath("//XCUIElementTypeButton[@name='OK']");

	
	public static void verifyHomeScreen() {
		pause(2);
		boolean flag = isElementDisplayed(headerText);
		Assert.assertEquals(flag, true);
	}

	public static void verifyHeaderText(String text) {
		pause(2);
		String headerTextValue = getTextOn(headerText);
		Assert.assertEquals(headerTextValue, text);
	}

	public static void verifyLinkText(String text) {
		pause(2);
		String youTubeLinkTextValue = getTextOn(youTubeLink);
		Assert.assertEquals(youTubeLinkTextValue, text);
	}

	public static void verifyBookCount() {
		pause(2);
		int bookListValue = getNumOfElements(bookList);
		Assert.assertTrue(bookListValue > 0);
	}

	public static void verifyBookName(String text) {
		pause(2);
		String bookNameText = getTextOn(bookName);
		Assert.assertEquals(bookNameText, text);
	}

	public static void verifyBooImage() {
		pause(5);
		boolean flag = isElementEnabled(bookImage);
		Assert.assertEquals(flag, true);
	}

	public static void verifyAuthorName(String text) {
		pause(2);
		String bookAuthorNameText = getTextOn(bookAuthorName);
		Assert.assertEquals(bookAuthorNameText, text);
	}

	public static void verifyAlertText(String text) {
		pause(2);
		String s1 = "You clicked on the ";
		String s2 = " book";
		String bookNameText = text;
		clickOn(bookName);
		String alertText = getTextOn(alertPopupText);
		Assert.assertEquals(alertText, s1 + bookNameText + s2);
		clickOn(alertOK);

	}

	public static void getTheLongestBookName() {
		pause(2);
		List<WebElement> web = listOfElements(bookList);
		for (WebElement x : web) {
			String text = x.getText();
			if (text.length() > 40) {
				System.out.println("The Book with the longest name is " + text);
			}
		}
	}

	public static void gotToYouTube() {
		pause(2);
		clickOn(youTubeLink);

	}
}
