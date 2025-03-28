package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.LoginPage;
import pages.LogoutClass;

public class TC_010LogoutTest extends ProjectBasicMethods {
	@BeforeTest
	public void setup() {
		sheetname = "ValidLogin";
		testName = "Logout Test";
		testDescription = "Testing the logout functionality";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}

	@Test(dataProvider = "readData")
	public void logoutTest(String username,String password) {
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginDetails(username, password);
		
		//logout
		LogoutClass logout =new LogoutClass(driver);
		logout.logout();
	}
}
