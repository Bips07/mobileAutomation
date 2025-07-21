package com.mobile;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class mobsize {
	
	public static void main(String[] args) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName", "5bea2711");
		capabilities.setCapability("appium:platformName", "android");
		capabilities.setCapability("appium:platformVersion", "15");
		capabilities.setCapability("appium:appPackage", "com.omr_branch");
		capabilities.setCapability("appium:appActivity", "com.omr_branch.MainActivity");
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		
		WebDriver driver = new AppiumDriver(capabilities);
		
		Dimension size = driver.manage().window().getSize();
		int width = (int) size.getWidth();
		int height = (int) size.getHeight();
		System.out.println(width);
		System.out.println(height);
		int centerX = (int) (width*0.5);
		System.out.println(centerX);
		int startY = (int) (height*0.8);
		System.out.println(startY);
		int endY = (int) (height*0.2);
		System.out.println(endY);
	}

}
