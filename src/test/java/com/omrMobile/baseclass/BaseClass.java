package com.omrMobile.baseclass;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AndroidDriver driver;
	static WebDriverWait wait;

	public void appLaunch(String deviceName, String platformName, String platformVersion, String appPackage,
			String appActivity, String automationName) {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName", deviceName);
		cap.setCapability("appium:platformName", platformName);
		cap.setCapability("appium:platformVersion", platformVersion);
		cap.setCapability("appium:appPackage", appPackage);
		cap.setCapability("appium:appActivity", appActivity);
		cap.setCapability("appium:automationName", automationName);

		driver = new AndroidDriver(cap);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public WebElement findLocatorBy(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	public void switchContext(String appType) {
		driver.context(appType);
	}

	public void waitForElement(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void swipe(int widthstartpercent, int widthendpercent, int heightstartpercent, int heightendpercent) {
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		int startX = (int) (((float) widthstartpercent / 100) * width);
		int endX = (int) (((float) widthendpercent / 100) * width);
		int startY = (int) (((float) heightstartpercent / 100) * width);
		int endY = (int) (((float) heightendpercent / 100) * width);

		PointerInput pi = new PointerInput(Kind.TOUCH, "finger1");
		Sequence s = new Sequence(pi, 1);
		s.addAction(pi.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), startX, startY));
		s.addAction(pi.createPointerDown(MouseButton.LEFT.asArg()));
		s.addAction(pi.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), endX, endY));
		s.addAction(pi.createPointerUp(MouseButton.LEFT.asArg()));

		List<Sequence> asList = Arrays.asList(s);
		RemoteWebDriver r = (RemoteWebDriver) driver;
		r.perform(asList);
	}

	public void swipeToElement(By by, int widthstartpercent, int widthendpercent, int heightstartpercent,
			int heightendpercent) {

		List<WebElement> element = driver.findElements(by);
		while (element.size() == 0) {
			swipe(widthstartpercent, widthendpercent, heightstartpercent, heightendpercent);
			element = driver.findElements(by);
		}
	}

}
