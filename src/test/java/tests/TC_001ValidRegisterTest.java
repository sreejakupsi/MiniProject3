package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HomePage;
import pages.RegisterPage;

public class TC_001ValidRegisterTest extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname = "ValidRegistration";
		testName = "Registration Test";
		testDescription = "Testing the registration functionality with positive cases";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}

	@Test(dataProvider = "readData")
	public void signUpTest(String username, String password, String confirmPassword, String fullname, String email)
			throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickRegister();
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.validRegistration(username, password, confirmPassword, fullname, email);

	}
}
