package com.mobile;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class firstClass {

	static AndroidDriver driver;
	WebDriverWait wait;
	public void appLaunch() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName", "5bea2711");
		capabilities.setCapability("appium:platformName", "android");
		capabilities.setCapability("appium:platformVersion", "15");
		capabilities.setCapability("appium:appPackage", "com.omr_branch");
		capabilities.setCapability("appium:appActivity", "com.omr_branch.MainActivity");
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		
		driver = new AndroidDriver(capabilities);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//adriver = (AndroidDriver) driver;
		
	}
	public void login() {
		
		WebElement txtEmail = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email Address']"));
		txtEmail.sendKeys("bipevstar@gmail.com");
		WebElement txtpassword = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']"));
		txtpassword.sendKeys("Chayowo@12");
		WebElement btnLogin=driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
		btnLogin.click();
		
	}
	public void searchHotel() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='header_welcome']")));
		WebElement strWelcome = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='header_welcome']"));
		System.out.println(strWelcome.getText());
		
		WebElement stateDropdown = driver.findElement(By.xpath("//android.widget.TextView[@text='Select State']"));
		stateDropdown.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Andhra Pradesh']")));
		WebElement stateClick = driver.findElement(By.xpath("//android.widget.TextView[@text='Andhra Pradesh']"));
		stateClick.click();
		
		WebElement cityDropdown = driver.findElement(By.xpath("//android.widget.TextView[@text='Select City']"));
		cityDropdown.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Tirupati']")));
		WebElement cityClick = driver.findElement(By.xpath("//android.widget.TextView[@text='Tirupati']"));
		cityClick.click();
		
		WebElement roomtypeDropdown = driver.findElement(By.xpath("//android.widget.TextView[@text='Select Room Type']"));
		roomtypeDropdown.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Deluxe']")));
		WebElement roomTypeClick = driver.findElement(By.xpath("//android.widget.TextView[@text='Deluxe']"));
		roomTypeClick.click();
		
		WebElement checkInCalendar = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='search_select_checkin']"));
		checkInCalendar.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='18 July 2025']")));
		WebElement checkInselect = driver.findElement(By.xpath("//android.view.View[@content-desc='18 July 2025']"));
		checkInselect.click();
		
		WebElement checkInOk = driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		checkInOk.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='search_select_checkout']")));
		WebElement checkOutCalendar = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='search_select_checkout']"));
		checkOutCalendar.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='24 July 2025']")));
		WebElement checkOutDate = driver.findElement(By.xpath("//android.view.View[@content-desc='24 July 2025']"));
		checkOutDate.click();
		
		WebElement checkOutOk = driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		checkOutOk.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='No. Of Room']")));
		WebElement no_of_rooms = driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Room']"));
		no_of_rooms.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='2-Two']")));
		WebElement no_of_roomsClick = driver.findElement(By.xpath("//android.widget.TextView[@text='2-Two']"));
		no_of_roomsClick.click();
		
		WebElement no_of_adults = driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Adults']"));
		no_of_adults.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='3-Three']")));
		WebElement no_of_adultsClick = driver.findElement(By.xpath("//android.widget.TextView[@text='3-Three']"));
		no_of_adultsClick.click();
		
		WebElement no_of_children = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='search_no_of_children']"));
		//no_of_children.click();
		
		no_of_children.sendKeys("1");
		
		WebElement btnSearch = driver.findElement(By.xpath("//android.widget.TextView[@text='Search']"));
		btnSearch.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='select_hotel_text']")));
		WebElement txtSelectHotel = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='select_hotel_text']"));
		System.out.println(txtSelectHotel.getText());
		
	}
	public void swipe() {
		

		Dimension size = driver.manage().window().getSize();
		int width = (int) size.getWidth();
		int height = (int) size.getHeight();
		int centerX = (int) (width*0.5);
		int startY = (int) (height*0.8);
		int endY = (int) (height*0.2);
		
		PointerInput pointerinput = new PointerInput(Kind.TOUCH, "finger1");
		
		Sequence sequence = new Sequence(pointerinput,1);
		
		sequence.addAction(pointerinput.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centerX, startY));
		sequence.addAction(pointerinput.createPointerDown(MouseButton.LEFT.asArg()));
		sequence.addAction(pointerinput.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centerX, endY));
		sequence.addAction(pointerinput.createPointerUp(MouseButton.LEFT.asArg()));
		
		List<Sequence> asList = Arrays.asList(sequence);
		
		RemoteWebDriver r = (RemoteWebDriver) driver;
		r.perform(asList);
	}
	
	public void swipeToElement(By by) {
		
		List<WebElement> elements = driver.findElements(by);
		while(elements.size()==0)
		{
			swipe();
			elements = driver.findElements(by);
		}
	}
	
	public void BookHotel() {
		
		WebElement btnContinue = driver.findElement(By.xpath("(//android.widget.TextView[@text='Continue'])[2]"));
		btnContinue.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='android:id/button2']")));
		WebElement btnOk = driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		btnOk.click();
		
		WebElement bookHotelPage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='book_hotel_text']"));
		System.out.println(bookHotelPage.getText());
		By btnNext = By.xpath("//android.widget.TextView[@text='Next']");
		swipeToElement(btnNext);
		
		WebElement rdoMyself = driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='book_hotel_booking_for'])[1]/android.widget.ImageView"));
		rdoMyself.click();
		
		WebElement ddnSalutation = driver.findElement(By.xpath("//android.widget.TextView[@text='Select Salutation']"));
		ddnSalutation.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Mr.']")));
		WebElement txtSalutation = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Mr.']"));
		txtSalutation.click();
		
		WebElement txtFirstName = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_first_name']"));
		txtFirstName.sendKeys("Test name");
		
		WebElement txtLastName = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_last_name']"));
		txtLastName.sendKeys("last Name");
		
		WebElement txtMobile = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_mobile_no']"));
		txtMobile.sendKeys("2365498712");
		
		WebElement txtEmail = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_email']"));
		txtEmail.sendKeys("test@gmail.com");
		
		WebElement btnNextC = driver.findElement(btnNext);
		btnNextC.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@resource-id='book_hotel_next_button']")));
		WebElement btnNext2 = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='book_hotel_next_button']"));
		WebElement textAnyOtherReq = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='book_hotel_any_other_request']"));
		System.out.println(textAnyOtherReq.getText());
		btnNext2.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='submitBtn']")));
		
		WebElement textTotalPayment = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'$')]"));
		System.out.println(textTotalPayment.getText());
		WebElement btnCreditCard = driver.findElement(By.xpath("//android.view.View[@resource-id='step-3']/android.view.View/android.view.View[3]/android.view.View"));
		btnCreditCard.click();
		Set<String> context = driver.getContextHandles();
		System.out.println(context);
		System.out.println(driver.getContext());
		
		By btnSubmitXpath = By.xpath("//android.widget.Button[@resource-id='submitBtn']");
		swipeToElement(btnSubmitXpath);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='payment_type']")));
		WebElement ddnCardType = driver.findElement(By.xpath("//android.view.View[@resource-id='payment_type']"));
		ddnCardType.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Debit Card']")));
		WebElement btnDebitCard = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Debit Card']"));
		btnDebitCard.click();
		
		WebElement ddnCard = driver.findElement(By.xpath("//android.view.View[@resource-id='card_type']"));
		ddnCard.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Visa']")));
		WebElement btnCard = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Visa']"));
		btnCard.click();
		
		WebElement txtCardNumber = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='card_no']"));
		txtCardNumber.sendKeys("5555555555552222");
		
		WebElement txtCardName = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='card_name']"));
		txtCardName.sendKeys("llllll");
		
		WebElement ddnCardMonth = driver.findElement(By.xpath("//android.view.View[@resource-id='card_month']"));
		ddnCardMonth.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='December']")));
		WebElement cardMonth = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='December']"));
		cardMonth.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='cvv']")));
		WebElement txtCvv = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='cvv']"));
		txtCvv.sendKeys("123");
		
		WebElement btnSub = driver.findElement(btnSubmitXpath);
		btnSub.click();
						
	}
	
	public void BookingConfirmed() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Booking is Confirmed')]")));
		WebElement textBookingConfirmed = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Booking is Confirmed')]"));
		
		String bookingconfirmed = textBookingConfirmed.getText();
		String[] fullText = bookingconfirmed.split(" ");
		String bookingId = fullText[0].substring(1);
		System.out.println("Booking Id:"+bookingId);
		
		
	}
	public static void main(String[] args) {

		firstClass obj = new firstClass();
		obj.appLaunch();
		obj.login();
		obj.searchHotel();
		By xpath = By.xpath("(//android.widget.TextView[@text='Continue'])[2]");
		obj.swipeToElement(xpath);
		String textHotelname = driver.findElement(xpath).getText();
		System.out.println(textHotelname);
		obj.BookHotel();
		obj.BookingConfirmed();
		
	}
	public void swipe2() {
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int centerX = (int) (0.5*width);
		int startY = (int) (0.8*height);
		PointerInput pi = new PointerInput(Kind.TOUCH, "finger1");
		Sequence s = new Sequence(pi, 1);
		s.addAction(pi.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centerX, startY));
		s.addAction(pi.createPointerDown(MouseButton.LEFT.asArg()));
		s.addAction(pi.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centerX, startY));
		s.addAction(pi.createPointerUp(MouseButton.LEFT.asArg()));
		
		List<Sequence> asList = Arrays.asList(s);
		
		RemoteWebDriver r = (RemoteWebDriver) driver;
		r.perform(asList);
		
		List<WebElement> element = driver.findElements(By.xpath(""));
		while(element.size()==0)
		{
			swipe();
			element = driver.findElements(By.xpath(""));
		}
	}

}
