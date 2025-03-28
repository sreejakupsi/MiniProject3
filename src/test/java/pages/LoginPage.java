package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basic.ProjectBasicMethods;

public class LoginPage extends ProjectBasicMethods {

	WebDriver driver;
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(id="username_span")
	WebElement usernameErrormsg;
	
	@FindBy(id="password_span")
	WebElement passwordErrormsg;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//login details
	public void loginDetails(String username,String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	//error message for invalid login
	public Map<String, String> getValidateMessage() {
		Map<String, String> errorMsg = new HashMap<>();
		errorMsg.put("Username", usernameErrormsg.getText());
		errorMsg.put("Password", passwordErrormsg.getText());
		return errorMsg;
	}
	
	//validating the error message and do assertion
	public void loginValidation(String testType,String expectedText) {
		Map<String, String> errorMessages = getValidateMessage();
		String actualText = errorMessages.get(testType.replace("Invalid", "")); 
		
		System.out.println(testType + " " + actualText);
		Assert.assertEquals(actualText, expectedText, "Validation message mismatch for " + testType);
	}
}
