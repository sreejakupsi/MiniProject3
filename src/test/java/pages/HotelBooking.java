package pages;

import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basic.ProjectBasicMethods;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HotelBooking extends ProjectBasicMethods {

	WebDriver driver;

	@FindBy(id = "first_name")
	WebElement firstnameField;

	@FindBy(id = "last_name")
	WebElement lastnameField;

	@FindBy(id = "address")
	WebElement addressField;

	@FindBy(id = "cc_num")
	WebElement ccnumField;

	@FindBy(id = "cc_cvv")
	WebElement cvvNoField;
	
	@FindBy(id="book_now")
	WebElement bookBtn;
	
	@FindBy(id="radiobutton_0")
	WebElement radioBtnClick;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(className = "welcome_menu")
	WebElement welcomeTest;
	
	@FindBy(id="first_name_span")
	WebElement firstnameErrormsg;
	
	@FindBy(id="last_name_span")
	WebElement lastnameErrormsg;
	
	@FindBy(id="address_span")
	WebElement addressErrormsg;
	
	@FindBy(id="cc_num_span")
	WebElement creditCardErrormsg;
	
	@FindBy(id="cc_cvv_span")
	WebElement cvvErrormsg;
	
	@FindBy(xpath=" //a[contains(text(), 'Change Password')]")
	WebElement changepasswordMenu;
	
	@FindBy(id="current_pass")
	WebElement currentPassword;
	
	@FindBy(id="new_password")
	WebElement newPassword;
	
	@FindBy(id="re_password")
	WebElement rePassword;
	
	@FindBy(id="Submit")
	WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(.,'Your Password is successfully updated!!!')]")
	WebElement changePasswordMsg;
	
	
	//constructor
	public HotelBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//select radio button to book the hotel
	public void selectHotel() {
		radioBtnClick.click();
		continueBtn.click();
	}
	
	//valid details to book a hotel
	public void validHotelBooking(String firstname, String lastname, String address, String creditcard, String cvv) {
		
		
		firstnameField.sendKeys(firstname);
		lastnameField.sendKeys(lastname);
		addressField.sendKeys(address);
		ccnumField.sendKeys(creditcard);

		// creditcard type dropdown
		WebElement ccTypeDropdown = driver.findElement(By.id("cc_type"));
		Select cctypeselect = new Select(ccTypeDropdown);
		cctypeselect.selectByVisibleText("VISA");

		// expire date -month
		WebElement monthDropdown = driver.findElement(By.id("cc_exp_month"));
		Select monthselect = new Select(monthDropdown);
		monthselect.selectByVisibleText("July");

		// expire date -year
		WebElement yearDropdown = driver.findElement(By.id("cc_exp_year"));
		Select yearselect = new Select(yearDropdown);
		yearselect.selectByVisibleText("2021");

		cvvNoField.sendKeys(cvv);
		bookBtn.click();
	
		System.out.println(welcomeTest.getText());
	}
	
	//get error message for invalid details
//	public Map<String, String> getValidationText() {
//	    Map<String, String> errorMsg = new HashMap<>();
//	    WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
//
//	    errorMsg.put("Firstname", getTextIfVisible(firstnameErrormsg, wait));
//	    errorMsg.put("Lastname", getTextIfVisible(lastnameErrormsg, wait));
//	    errorMsg.put("Address", getTextIfVisible(addressErrormsg, wait));
//	    errorMsg.put("CCnumber", getTextIfVisible(creditCardErrormsg, wait));
//	    errorMsg.put("cvvNumber", getTextIfVisible(cvvErrormsg, wait));
//	    return errorMsg;
//	}
	
	public String getValidationText(String testType) {
	    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

	    try {
	        if (testType.equalsIgnoreCase("InvalidFirstname")) {
	            return wait.until(ExpectedConditions.visibilityOf(firstnameErrormsg)).getText().trim();
	        } else if (testType.equalsIgnoreCase("InvalidLastname")) {
	            return wait.until(ExpectedConditions.visibilityOf(lastnameErrormsg)).getText().trim();
	        } else if (testType.equalsIgnoreCase("InvalidAddress")) {
	            return wait.until(ExpectedConditions.visibilityOf(addressErrormsg)).getText().trim();
	        } else if (testType.equalsIgnoreCase("InvalidCreditcardnumber")) {
	            return wait.until(ExpectedConditions.visibilityOf(creditCardErrormsg)).getText().trim();
	        } else if (testType.equalsIgnoreCase("InvalidCvvNumber")) {
	            return wait.until(ExpectedConditions.visibilityOf(cvvErrormsg)).getText().trim();
	        } else {
	            return "Not Found";  
	        }
	    } catch (Exception e) {
	        return "Not Found";  
	    }
	}




	
	
	//validate the error message and do assertion
	public HotelBooking bookingValidation(String testType, String expectedText) throws InterruptedException {
	    String actualText = getValidationText(testType);
	    System.out.println("Error message for " + testType + ": " + actualText);
	    return this;
	}




	
	//check the change password functionality
	public void changePassword() {
		changepasswordMenu.click();
		currentPassword.sendKeys("Kupsi@12345");
		newPassword.sendKeys("Kupsi123");
		rePassword.sendKeys("Kupsi123");
		submitBtn.click();
		System.out.println("Password changed successfully");
		changePasswordMsg.getText();
	}
}
