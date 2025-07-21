package com.omrMobile.StepDefinition;

import com.omrMobile.baseclass.BaseClass;
import com.omrMobile.pages.ExploreHotel;
import com.omrMobile.pages.LoginPage;

import io.cucumber.java.en.*;

public class loginStep extends BaseClass{
	public loginStep() throws Exception{
		super();
	}
	LoginPage l = new LoginPage();
	ExploreHotel eH = new ExploreHotel();
	@Given("user is on OMR branch app login page")
	public void user_is_on_omr_branch_app_login_page() {
		appLaunch("5bea2711", "android", "15", "com.omr_branch", "com.omr_branch.MainActivity", "UIAutomator2");
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		l.login("bipevstar@gmail.com", "Chayowo@12");
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		l.clickLogin();
	}
	@Then("user should be redirected to the seach page")
	public void user_should_be_redirected_to_the_seach_page() {
	eH.getWelcomeText();
	}




}
