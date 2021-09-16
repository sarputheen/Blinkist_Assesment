package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class YouTubeVideoPlay extends BasePage {


	public YouTubeVideoPlay(AppiumDriver driver2) {
		super(driver2);
	}
	private static By screen = By.xpath("//XCUIElementTypeOther[@name='YouTube Video Player']/XCUIElementTypeOther/XCUIElementTypeOther");
	private static By btnPlay = By.xpath("//XCUIElementTypeSwitch[@name='Play video']");
	private static By btnPause = By.xpath("//XCUIElementTypeSwitch[@name='Pause video']");
	private static By btnNext = By.xpath("//XCUIElementTypeButton[@name='Next video']");
	private static By btnPrevious = By.xpath("//XCUIElementTypeButton[@name='Previous video']");
	private static By btnSettings = By.xpath("//XCUIElementTypeButton[@name='Playback Settings']");
	private static By btnAtuoplayOff = By.xpath("//XCUIElementTypeSwitch[@name='Autoplay is off']");
	private static By btnAtuoplayOn = By.xpath("//XCUIElementTypeSwitch[@name='Autoplay is on']");
	
	public static void pauseVideo() {
		pause(2);
		click(screen);
		pause(1);
		click(screen);
		click(btnPause);
		
	
	}
	
	public static void autoPlayOff() {
		click(btnAtuoplayOn);
		
	
	}
	public static void autoPlayOn() {
		click(btnAtuoplayOff);
		
	}
	public static void playVideo() {
		click(btnPlay);
		
	
	}
	public static void playNextVideo() {
		click(btnNext);
		
	
	}
	public static void playPreviousVideo() {
		pause(15);
		click(screen);
		click(screen);
		click(btnPrevious);
		pause(3);
	
	}
	
}
