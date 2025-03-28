package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HotelBooking;
import pages.LoginPage;
import pages.SearchAndCancel;

public class TC_008SerachIdTest extends ProjectBasicMethods{

	
	@BeforeTest
	public void setup() {
		sheetname = "ValidLogin";
		testName = "Search id Test";
		testDescription = "Testing the search id functionality";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	
	@Test(dataProvider = "readData")
	public void searchId(String username, String password) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginDetails(username,password);
		
		SearchAndCancel searchpage= new SearchAndCancel(driver);
		searchpage.searchOrderId();
	}
	
}
