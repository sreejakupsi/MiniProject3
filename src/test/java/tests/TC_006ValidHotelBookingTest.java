package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HotelBooking;
import pages.HotelSearchPage;
import pages.LoginPage;

public class TC_006ValidHotelBookingTest extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname = "ValidHotelBooking";
		testName = "Hotel booking Test";
		testDescription = "Testing the hotel booking functionality with positive cases";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	@Test(dataProvider = "readData")
	public void validHotelBooking(String username,String password,String checkindate,String checkoutdate,String firstname, String lastname, String address, String creditcard, String cvv) {
		//login
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginDetails(username,password);
		
		HotelSearchPage hotelsearch =new HotelSearchPage(driver);
		hotelsearch.validHotelSearch(checkindate, checkoutdate);
	
		HotelBooking hotelbooking= new HotelBooking(driver);
		hotelbooking.selectHotel();
		hotelbooking.validHotelBooking(firstname,lastname,address,creditcard,cvv);
	}
	
}
