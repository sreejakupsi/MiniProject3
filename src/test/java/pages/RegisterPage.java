package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import basic.ProjectBasicMethods;

public class RegisterPage extends ProjectBasicMethods {

	WebDriver driver;

	@FindBy(id = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "re_password")
	WebElement confirmPasswordField;

	@FindBy(id = "full_name")
	WebElement fullnameField;

	@FindBy(id = "email_add")
	WebElement emailField;

	@FindBy(id = "tnc_box")
	WebElement checkBox;

	@FindBy(id = "Submit")
	WebElement registerBtn;

	@FindBy(id = "username_span")
	WebElement usernameErrormsg;

	@FindBy(id = "password_span")
	WebElement passwordErrormsg;

	@FindBy(id = "re_password_span")
	WebElement cnfPasswordErrormsg;

	@FindBy(id = "full_name_span")
	WebElement fullnameErrormsg;

	@FindBy(id = "email_add_span")
	WebElement emailErrormsg;

	//constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//register the application with valid details
	public void validRegistration(String username, String password, String confirmPassword, String fullname, String email) throws InterruptedException {

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		fullnameField.sendKeys(fullname);
		emailField.sendKeys(email);
		Thread.sleep(30000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
		registerBtn.click();
		System.out.println("Registered successfully");
	}

	//validating error message for invalid credientials
	public Map<String, String> getValidateMessage() {
		Map<String, String> errorMsg = new HashMap<>();
		errorMsg.put("Username", usernameErrormsg.getText());
		errorMsg.put("Password", passwordErrormsg.getText());
		errorMsg.put("ConfirmPassword", cnfPasswordErrormsg.getText()); // Fixed
		errorMsg.put("Fullname", fullnameErrormsg.getText());
		errorMsg.put("Email", emailErrormsg.getText());
		return errorMsg;
	}
	
	//Assertion
	public void registrationValidation(String testType, String expectedText) {
		Map<String, String> errorMessages = getValidateMessage();
		String actualText = errorMessages.get(testType.replace("Invalid", "")); // Extract specific message
		
		System.out.println(testType + " " + actualText);
		Assert.assertEquals(actualText, expectedText, "Validation message mismatch for " + testType);
	}
}
