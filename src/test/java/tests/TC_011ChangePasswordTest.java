package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HotelBooking;
import pages.LoginPage;
import pages.LogoutClass;

public class TC_011ChangePasswordTest extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname = "ValidLogin";
		testName = "Change password Test";
		testDescription = "Testing the change password functionality";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	
	@Test(dataProvider = "readData")
	public void logout(String username, String password) {
		//login
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginDetails(username,password);
		
		//change password
		HotelBooking hotelbooking= new HotelBooking(driver);
		hotelbooking.changePassword();
	}
}
