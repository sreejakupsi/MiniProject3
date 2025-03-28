package basic;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

import java.io.IOException;

public class ProjectBasicMethods extends Utility {

	@BeforeSuite
	public void reportInitialization() {
		//to create report in the given location
		ExtentSparkReporter reporter= new ExtentSparkReporter("C:\\Users\\Kupsi\\eclipse-workspace\\hotel-booking\\reports\\HotelBookingReporter.html");
		reporter.config().setReportName("Hotel booking report");
		
		//to capture the test data
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		
		
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException {
		browserLaunch();
	}

	@AfterMethod
	public void browserClose() {
		closeBrowser();
	}

	@DataProvider(name = "readData")
	public String[][] readData() throws IOException {
	    System.out.println("Reading data from sheet: " + sheetname);
	    return readExcel(sheetname);
	}
	
	   @AfterSuite
	   public void reportClose() {
		   extent.flush();//manatory to close the report else it results in error
	   }
}
