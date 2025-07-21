package com.omrMobile.TestCase;


import com.omrMobile.baseclass.BaseClass;
import com.omrMobile.pages.ExploreHotel;
import com.omrMobile.pages.LoginPage;

public class TC_001 extends BaseClass{
	
	
	public void testCase001() throws Exception {
		LoginPage l = new LoginPage();
		ExploreHotel e = new ExploreHotel();
		appLaunch("5bea2711", "android", "15", "com.omr_branch", "com.omr_branch.MainActivity", "UIAutomator2");
		l.login("bipevstar@gmail.com", "Chayowo@12");
		e.searchHotel();
		
	}
}
