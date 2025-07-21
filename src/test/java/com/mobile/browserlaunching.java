package com.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class browserlaunching {

	String orderID;
	WebDriverWait wait;
	static AndroidDriver driver;
	JavascriptExecutor js;

	
	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName", "5bea2711");
		cap.setCapability("appium:platformName", "android");
		cap.setCapability("appium:platformVersion", "15");
		cap.setCapability("appium:automationName", "UIAutomator2");
		cap.setCapability("appium:browserName", "Chrome");

		WebDriver Wdriver = new AndroidDriver(cap);

		Wdriver.get("https://omrbranch.com");
		driver = (AndroidDriver) Wdriver;

		driver.context("NATIVE_APP");
		WebElement location = Wdriver.findElement(By.xpath(
				"//android.view.ViewGroup[@resource-id='com.android.chrome:id/coordinator']/android.view.View[1]"));
		location.click();

		driver.context("CHROMIUM");
		browserlaunching obj = new browserlaunching();
		obj.login();
		obj.search();
		obj.HotelSelect();
		obj.hotelBook();
		obj.bookingConfirmation();
		obj.myBookingsModify();
		obj.bookingCancel();

	}

	public void login() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement txtUserName = driver.findElement(By.id("email"));
		WebElement txtPassword = driver.findElement(By.id("pass"));
		WebElement btnLogin = driver.findElement(By.xpath("//*[@value='login']"));
		txtUserName.sendKeys("bipevstar@gmail.com");
		txtPassword.sendKeys("Chayowo@12");
		btnLogin.click();
		WebElement strWelcome = driver.findElement(By.xpath("//*[@data-testid='username']"));
		System.out.println("Login :" + strWelcome.getText());
		WebElement linkHotel = driver.findElement(By.xpath("//*[@data-href='https://omrbranch.com/hotel-booking']"));
		linkHotel.click();
	}

	public void search() {
		js = (JavascriptExecutor) driver;
		WebElement strExplorer = driver.findElement(By.xpath("//*[@class='fliter_box_inner']/h5"));
		System.out.println("Hotel booking :" + strExplorer.getText());
		WebElement txtState = driver.findElement(By.name("state"));
		Select selectState = new Select(txtState);
		selectState.selectByValue("Tamil Nadu");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value= 'Chennai']")));
		WebElement txtCity = driver.findElement(By.name("city"));
		Select selectCity = new Select(txtCity);
		selectCity.selectByValue("Chennai");
		WebElement txtType = driver.findElement(By.id("room_type"));
		Select selectType = new Select(txtType);
		if (selectType.isMultiple()) {
			selectType.selectByValue("Standard");
			selectType.selectByValue("Deluxe");
//			selectType.selectByValue("Suite");
//			selectType.selectByValue("Luxury");
//			selectType.selectByValue("Studio");
		} else {
			selectType.selectByValue("Standard");
		}
		driver.findElement(By.name("check_in")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'6')]")));
		WebElement txtCheckinDate = driver.findElement(By.xpath("//a[contains(text(),'6')]"));
		txtCheckinDate.click();
	//	List<WebElement> close = driver.findElements(By.xpath("//*[@id='tawk-mpreview-close']/i"));
//		System.out.println(close);
//		if (!close.isEmpty()) {
//			for (WebElement webElement : close) {
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].scrollIntoView", webElement);
//				webElement.click();
//			}
//		}
		driver.findElement(By.name("check_out")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class ='ui-state-default'] [contains(text(),'20')]")));
		WebElement txtCheckOutDate = driver
				.findElement(By.xpath("//a[@class ='ui-state-default'] [contains(text(),'20')]"));
		txtCheckOutDate.click();
		WebElement txtNo_of_rooms = driver.findElement(By.name("no_rooms"));
		Select selectNo_of_rooms = new Select(txtNo_of_rooms);
		selectNo_of_rooms.selectByValue("3");
		WebElement txtNo_of_adults = driver.findElement(By.name("no_adults"));
		Select selectNo_of_adults = new Select(txtNo_of_adults);
		selectNo_of_adults.selectByValue("2");
		WebElement txtNo_of_child = driver.findElement(By.name("no_child"));
		txtNo_of_child.sendKeys("1");
		WebElement searchFrame = driver.findElement(By.id("hotelsearch_iframe"));
		driver.switchTo().frame(searchFrame);
		WebElement btnSearch = driver.findElement(By.xpath("//*[@id='searchBtn']"));
		btnSearch.click();
	}

	public void HotelSelect() {

		WebElement shadowHost = (WebElement) js.executeScript("return document.querySelector('custom-element')");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-12']/div/h5")));
		WebElement strSelectHotel = driver.findElement(By.xpath("//*[@class='col-md-12']/div/h5"));
		System.out.println("Hotel Selection: " + strSelectHotel.getText());
		List<WebElement> hotelNames = driver.findElements(By.xpath("//div[@class='col-md-5 hotel-suites']/h5"));
		List<WebElement> fullPrices = driver.findElements(By.xpath("//*[@class='total-prize']"));
		for (int i = 0; i < hotelNames.size(); i++) {
			System.out.println(hotelNames.get(i).getText());
			System.out.println(fullPrices.get(i).getText());
		}
		List<WebElement> btnsContinue = driver.findElements(By.xpath("//a[@class='btn filter_btn']"));
		btnsContinue.get(5).click();
		driver.switchTo().alert().accept();
	}

	public void hotelBook() {

		WebElement strHotelName = driver.findElement(By.xpath("//*[@class='px-3 py-2']"));
		System.out.println(strHotelName.getText());
		WebElement radioOwn = driver.findElement(By.id("own"));
		radioOwn.click();
		WebElement salutation = driver.findElement(By.name("title"));
		Select selectSalutation = new Select(salutation);
		selectSalutation.selectByValue("Mr");
		driver.findElement(By.name("first_name")).sendKeys("Bipi");
		driver.findElement(By.name("last_name")).sendKeys("EVS");
		driver.findElement(By.name("phone")).sendKeys("2546987463");
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
//		WebElement gstCheckBox = driver.findElement(By.name("gst"));
//		gstCheckBox.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registration")));
//		WebElement registrationNo = driver.findElement(By.name("registration"));
//		registrationNo.sendKeys("9043592058");
//		WebElement companyName = driver.findElement(By.name("company_name"));
//		companyName.sendKeys("Greens Tech OMR Branch");
//		WebElement location = driver.findElement(By.name("company_address"));
//		location.sendKeys("Thoraipakkam");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step1next")));
		WebElement btnNext = driver.findElement(By.id("step1next"));
		btnNext.click();
		btnNext.click();
		WebElement earlyCheckIn = driver.findElement(By.id("early"));
		try {
			earlyCheckIn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element Interuppted Exception");
		}
		WebElement request = driver.findElement(By.name("other_request"));
		request.sendKeys("Valet parking needed");
			
		WebElement btnNext2 = driver.findElement(By.id("step2next"));
		js.executeScript("arguments[0].click", btnNext2);
		//btnNext2.click();
		WebElement creditCard = driver.findElement(By.xpath("//*[@class='credit-card pm']"));
		creditCard.click();
		
		
		WebElement paymentType = driver.findElement(By.name("payment_type"));
		Select selectpaymentType = new Select(paymentType);
		selectpaymentType.selectByValue("debit_card");
		WebElement cardType = driver.findElement(By.name("card_type"));
		Select selectCardType = new Select(cardType);
		selectCardType.selectByValue("visa");
		WebElement cardNo = driver.findElement(By.name("card_no"));
		cardNo.sendKeys("5555555555552222");
		WebElement cardName = driver.findElement(By.name("card_name"));
		cardName.sendKeys("testing");
		WebElement month = driver.findElement(By.name("card_month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("07");
		WebElement year = driver.findElement(By.name("card_year"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("2032");
		WebElement txtCvv = driver.findElement(By.name("cvv"));
		txtCvv.sendKeys("123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn")));
		WebElement btnSubmit = driver.findElement(By.id("submitBtn"));
		btnSubmit.click();
	}

	public void bookingConfirmation() {
		WebElement bookingId = driver.findElement(By.xpath("//*[@class='couppon-code']/strong"));
		String text = bookingId.getText();
		orderID = text.replace("#", "");
		System.out.println("Booking ID :" + orderID);
		WebElement strBooking = driver.findElement(By.xpath("//*[@class='couppon-code']"));
		String txtBooking = strBooking.getText();
		String confirmed = txtBooking.replace(text, "").trim();
		System.out.println(confirmed);
		WebElement txtHotelName = driver.findElement(By.xpath("//*[@class='seccess-box text-center']/p/strong"));
		System.out.println(txtHotelName.getText());
		List<WebElement> buttonList = driver.findElements(By.xpath("//*[@class='btn filter_btn']"));
		buttonList.get(1).click();
	}

	public void myBookingsModify() {
		WebElement bookingCount = driver.findElement(By.xpath("//*[@class='col-md-5']/h4"));
		String txtbookingCount = bookingCount.getText();
		String res = txtbookingCount.replaceAll("[^0-9]", "");
		System.out.println("Booking count: " + res);
		WebElement searchBox = driver.findElement(By.xpath("//*[@class='form-control w-50 d-inline-block']"));
		searchBox.sendKeys(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='edit btn filter_btn']")));
		System.out.println(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-7 mobile-space-none']/a/h5")));
		WebElement hotelName = driver.findElement(By.xpath("//*[@class='col-md-7 mobile-space-none']/a/h5"));
		System.out.println(hotelName.getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='total-prize']")));
		WebElement hotelPrice = driver.findElement(By.xpath("//*[@class='total-prize']"));
		try {
			System.out.println(hotelPrice.getText());
		} catch (StaleElementReferenceException e) {
			System.out.println("Stale Element Exception");
		}
		// driver.navigate().refresh();
		searchBox = driver.findElement(By.xpath("//*[@class='form-control w-50 d-inline-block']"));
		// searchBox.sendKeys(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='my-booking  prize']/button")));
		WebElement btnEdit = driver.findElement(By.xpath("//*[@class='my-booking  prize']/button"));
		try {
			btnEdit.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("Stale Element Exception");
		}
		System.out.println("Entered Editing screen");
		WebElement dateCheckIn = driver.findElement(By.name("check_in"));
		dateCheckIn.clear();
		dateCheckIn.sendKeys("2025-07-02");
		WebElement btnConfirm = driver.findElement(By.xpath("//*[@class='edit btn filter_btn']"));
		btnConfirm.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alertMsg']")));
		WebElement msgBookingUpdated = driver.findElement(By.xpath("//*[@class='alertMsg']"));
		System.out.println(msgBookingUpdated.getText());
	}

	public void bookingCancel() {

		WebElement bookingCount = driver.findElement(By.xpath("//*[@class='col-md-5']/h4"));
		String txtbookingCount = bookingCount.getText();
		String res = txtbookingCount.replaceAll("[^0-9]", "");
		System.out.println("Booking count: " + res);
		WebElement searchBox = driver.findElement(By.xpath("//*[@class='form-control w-50 d-inline-block']"));
		searchBox.sendKeys(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='edit btn filter_btn']")));
		System.out.println(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-7 mobile-space-none']/a/h5")));
		WebElement hotelName = driver.findElement(By.xpath("//*[@class='col-md-7 mobile-space-none']/a/h5"));
		System.out.println(hotelName.getText());
		WebElement hotelPrice = driver.findElement(By.xpath("//*[@class='total-prize']"));
		try {
			System.out.println(hotelPrice.getText());
		} catch (StaleElementReferenceException e) {
			System.out.println("Stale Element Exception");
		}

		driver.navigate().refresh();
		searchBox = driver.findElement(By.xpath("//*[@class='form-control w-50 d-inline-block']"));
		searchBox.sendKeys(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cancle btn filter_btn']")));
		WebElement btnCancel = driver.findElement(By.xpath("//*[@class='cancle btn filter_btn']"));
		btnCancel.click();
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alertMsg']")));
		WebElement msgBookingUpdated = driver.findElement(By.xpath("//*[@class='alertMsg']"));
		System.out.println(msgBookingUpdated.getText());
		searchBox = driver.findElement(By.xpath("//*[@class='form-control w-50 d-inline-block']"));
		searchBox.sendKeys(orderID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cancle btn filter_btn mb-3']")));
		WebElement txtCancelled = driver.findElement(By.xpath("//*[@class='cancle btn filter_btn mb-3']"));
		System.out.println(txtCancelled.getText());

	}

}
