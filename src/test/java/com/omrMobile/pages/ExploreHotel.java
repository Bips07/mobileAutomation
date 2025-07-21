package com.omrMobile.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import com.omrMobile.baseclass.BaseClass;

public class ExploreHotel extends BaseClass {
	Properties prop = new Properties();
	By textWelcome,ddnState,ddnStateSelect,ddnCity, ddnCitySelect,ddnRoomType,ddnRoomTypeClick,txtcheckIn,dateCheckIn,btnCalendarOk,  txtCheckOut, dateCheckOut, ddnNoOfRooms,ddnNoOfRoomSelect, ddnNoOfAdults, ddnNoOfAdultsSelect,txtNoOfChildren,btnSearch;
	
	public ExploreHotel() throws FileNotFoundException, IOException {
		prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties"));
		textWelcome = By.xpath("//android.widget.TextView[@resource-id='header_welcome']");
		ddnState = By.xpath("//android.widget.TextView[@text='Select State']");
		ddnStateSelect = By.xpath("//android.widget.TextView[@text='"+prop.getProperty("state")+"']");
		ddnCity = By.xpath("//android.widget.TextView[@text='Select City']");
		ddnCitySelect = By.xpath("//android.widget.TextView[@text='"+prop.getProperty("city")+"']");
		ddnRoomType = By.xpath("//android.widget.TextView[@text='Select Room Type']");
		ddnRoomTypeClick = By.xpath("//android.widget.TextView[@text='"+prop.getProperty("roomType")+"']");
		txtcheckIn = By.xpath("//android.widget.EditText[@content-desc='search_select_checkin']");
		dateCheckIn = By.xpath("//android.view.View[@content-desc='"+prop.getProperty("checkIn")+"']");
		btnCalendarOk = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
		txtCheckOut = By.xpath("//android.widget.EditText[@content-desc='search_select_checkout']");
		dateCheckOut = By.xpath("//android.view.View[@content-desc='"+prop.getProperty("checkOut")+"']");
		ddnNoOfRooms = By.xpath("//android.widget.TextView[@text='No. Of Room']");
		ddnNoOfRoomSelect = By.xpath("//android.widget.TextView[@text='"+prop.getProperty("noOfRooms")+"']");
		ddnNoOfAdults = By.xpath("//android.widget.TextView[@text='No. Of Adults']");
		ddnNoOfAdultsSelect = By.xpath("//android.widget.TextView[@text='"+prop.getProperty("noOfAdults")+"']");
		txtNoOfChildren = By.xpath("//android.widget.EditText[@content-desc='search_no_of_children']");
		btnSearch = By.xpath("//android.widget.TextView[@text='Search']");
	}
	public void searchHotel() throws FileNotFoundException, IOException {
		
		
		elementClick(findLocatorBy(ddnState));
		System.err.println(ddnStateSelect);
		waitForElement(ddnStateSelect);
		elementClick(findLocatorBy(ddnStateSelect));
		elementClick(findLocatorBy(ddnCity));
		waitForElement(ddnCitySelect);
		elementClick(findLocatorBy(ddnCitySelect));
		elementClick(findLocatorBy(ddnRoomType));
		waitForElement(ddnRoomTypeClick);
		elementClick(findLocatorBy(ddnRoomTypeClick));
		elementClick(findLocatorBy(txtcheckIn));
		waitForElement(dateCheckIn);
		elementClick(findLocatorBy(dateCheckIn));
		elementClick(findLocatorBy(btnCalendarOk));
		elementClick(findLocatorBy(txtCheckOut));
		waitForElement(dateCheckOut);
		elementClick(findLocatorBy(dateCheckOut));
		elementClick(findLocatorBy(btnCalendarOk));
		elementClick(findLocatorBy(ddnNoOfRooms));
		waitForElement(ddnNoOfRoomSelect);
		elementClick(findLocatorBy(ddnNoOfRoomSelect));
		elementClick(findLocatorBy(ddnNoOfAdults));
		waitForElement(ddnNoOfAdultsSelect);
		elementClick(findLocatorBy(ddnNoOfAdultsSelect));
		elementClick(findLocatorBy(btnSearch));		
	}
	
	public void getWelcomeText() {
		waitForElement(textWelcome);
		System.out.println(elementGetText(findLocatorBy(textWelcome)));
	}

}
