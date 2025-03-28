package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HomePage;
import pages.HotelSearchPage;
import pages.LoginPage;

public class TC_005HotelSearch extends ProjectBasicMethods {

	
	@BeforeTest
	public void setup() {
		sheetname = "HotelSearch";
		testName = "HotelSearch Test";
		testDescription = "Testing the hotel search functionality";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	@Test(dataProvider = "readData")
	public void validHotelSearch(String username,String password,String checkindate,String checkoutdate) {
		//login
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginDetails(username,password);
		
		HomePage homepage=new HomePage(driver);
		homepage.homepageDisplay();
		
		HotelSearchPage hotelsearch=new HotelSearchPage(driver);
		hotelsearch.validHotelSearch(checkindate, checkoutdate);
	
	}
}
