package com.omr.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class BaseClass {
	public static WebDriver driver;
	Select select;
	JavascriptExecutor executor;
	TakesScreenshot takesScreenshot;
	Actions actions;
	Alert alert;

	public void switchContext(String appType) {
		AndroidDriver androidDriver = (AndroidDriver) driver;
		switch (appType) {
		case "NATIVE_APP":
			androidDriver.context(appType);
			break;
		case "CHROMIUM":
			androidDriver.context(appType);
			break;
		default:
			break;
		}
	}

	public void appLaunch(String type, String browserName, String deviceName, String platformName,
			String platformVersion, String appPackage, String appActivity, String automationName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName", deviceName);
		capabilities.setCapability("appium:platformName", platformName);
		capabilities.setCapability("appium:platformVersion", platformVersion);
		capabilities.setCapability("appium:automationName", automationName);
		switch (type) {

		case "APP":
			capabilities.setCapability("appium:appPackage", appPackage);
			capabilities.setCapability("appium:appActivity", appActivity);

			break;
		case "BROWSER":
			capabilities.setCapability("appium:browserName", browserName);

			break;

		default:
			break;
		}
		driver = new AppiumDriver(capabilities);

	}

	public void scroll(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dragAndDrop(WebElement source, WebElement dest) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, dest).perform();
	}

	public void screenshot(WebElement element, String fileName) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(
				"C:\\Users\\Velmurugan\\eclipse-workspace\\FrameworkClass930AMBatch\\output\\" + fileName + ".png"));
	}

	public void screenshot(String fileName) throws IOException {
		takesScreenshot = (TakesScreenshot) driver;
		File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(
				"C:\\Users\\Velmurugan\\eclipse-workspace\\FrameworkClass930AMBatch\\output\\" + fileName + ".png"));
	}

	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWindowId : windowHandles) {
			if (!windowHandle.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
			}
		}
	}

	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public List<String> getAllOptions(WebElement element) {
		List<String> allOptionsText = new ArrayList<>();

		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}

	public void selectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectOptionByValue(WebElement element, String text) {
		select = new Select(element);
		select.selectByValue(text);
	}

	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static void enterApplnUrl(String url) {
		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data);
		}
	}

	public void elementSendKeysEnter(WebElement element, String data) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data, Keys.ENTER);
		}
	}

	public void elementSendKeysJs(WebElement element, String data) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();
		}
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String exp) {
		WebElement element = driver.findElement(By.xpath(exp));
		return element;
	}

	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void closeWindow() {
		driver.quit();
	}

	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = element.getText();
		return text;
	}

//99%-->value is fixed
	public String getDomProperty(WebElement element) {
		visibilityOfElement(element);
		String domProperty = element.getDomProperty("value");
		return domProperty;
	}

	// 1%-->value is NOT fixed
	public String getDomProperty(WebElement element, String attributeName) {
		visibilityOfElement(element);
		String domProperty = element.getDomProperty(attributeName);
		return domProperty;
	}


}
