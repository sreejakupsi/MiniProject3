package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.LoginPage;

public class TC_004InvalidLoginTest extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname = "InvalidLogin";
		testName = "Login Test";
		testDescription = "Testing the login functionality with negative cases";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	@Test(dataProvider ="readData")
	public void invalidLogin(String username,String password,String testType, String expectedText) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginDetails(username,password);
		loginpage.loginValidation(testType,expectedText);
	}
}
