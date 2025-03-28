package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HotelBooking;
import pages.HotelSearchPage;
import pages.LoginPage;

public class TC_007InvalidHotelBooking  extends ProjectBasicMethods{


	@BeforeTest
	public void setup() {
		sheetname = "InvalidHotelBooking";
		testName = "Hotel booking Test";
		testDescription = "Testing the hotel booking functionality with negative cases";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	
	@Test(dataProvider = "readData")
	public void invalidHotelBooking(String username,String password,String checkindate,String checkoutdate,String firstname, String lastname, String address, String creditcard, String cvv,String testType,String expectedText) throws InterruptedException {
		//login
				LoginPage loginpage=new LoginPage(driver);
				loginpage.loginDetails(username,password);
				
				HotelSearchPage hotelsearch =new HotelSearchPage(driver);
				hotelsearch.validHotelSearch(checkindate, checkoutdate);
				
				HotelBooking hotelbooking= new HotelBooking(driver);
				hotelbooking.selectHotel();
				hotelbooking.validHotelBooking(firstname,lastname,address,creditcard,cvv);
				hotelbooking.bookingValidation(testType,expectedText);
			
	}
	


}
