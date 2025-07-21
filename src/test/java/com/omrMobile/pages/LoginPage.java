package com.omrMobile.pages;

import org.openqa.selenium.*;

import com.omrMobile.baseclass.BaseClass;

public class LoginPage extends BaseClass{
	
	By txtEmail = By.xpath("//android.widget.EditText[@content-desc='Email Address']");
	By txtPassword = By.xpath("//android.widget.EditText[@content-desc='Password']");
	By btnLogin = By.xpath("//android.widget.TextView[@text='Login']");
	By errorMessage = By.xpath("//android.widget.TextView[@resource-id='login_error_message']");
	
	public void login(String userName, String password) {
		
		elementSendKeys(findLocatorBy(txtEmail), userName);
		elementSendKeys(findLocatorBy(txtPassword), password);
		//deleting
	}
	
	public void clickLogin() {
		elementClick(findLocatorBy(btnLogin));
		//addoing
	}
	
	public String getErrorMessage() {
		
		String mess = elementGetText(findLocatorBy(errorMessage));
		return mess;
	}

}
