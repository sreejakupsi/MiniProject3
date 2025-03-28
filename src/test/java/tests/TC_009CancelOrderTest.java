package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.LoginPage;
import pages.SearchAndCancel;

public class TC_009CancelOrderTest extends ProjectBasicMethods {

	
	@BeforeTest
	public void setup() {
		sheetname = "ValidLogin";
		testName = "Cncel order";
		testDescription = "Testing the cancel order functionality";
		testAuthor = "Sreeja";
		testCategory = "Smoke Testing";
	}
	
	
	@Test(dataProvider = "readData")
	public void cancelOrder(String username,String password) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginDetails(username,password);
		
		SearchAndCancel cancelorder=new SearchAndCancel(driver);
		cancelorder.cancelHotel();
	}
}
