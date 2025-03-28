package tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HomePage;
import pages.RegisterPage;

public class TC_002InvalidRegisterTest extends ProjectBasicMethods {

	
	@BeforeTest
	public void setup() {
		sheetname = "InvalidRegistration";
		testName = "Registration Test";
		testDescription = "Testing the registration functionality with negative cases";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}

	@Test(dataProvider = "readData")
	public void signUpTest(String username, String password, String confirmPassword, String fullname, String email,String testType,String expectedText)
			throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickRegister();
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.validRegistration(username, password, confirmPassword, fullname, email);
		registerpage.registrationValidation(testType, expectedText);

	}
}
