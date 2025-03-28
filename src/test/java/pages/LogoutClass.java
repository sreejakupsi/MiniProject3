package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basic.ProjectBasicMethods;

public class LogoutClass extends ProjectBasicMethods {

	
	WebDriver driver;
	
	@FindBy(xpath=" //a[contains(text(), 'Logout')]")
	WebElement logoutMenu; 
	
	@FindBy(xpath="//td[contains(text(),'You have successfully logged out.' ) ]")
	WebElement logoutMessgae;
	
	//constructor
	public LogoutClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//logout the application
	public void logout() {
		logoutMenu.click();
		System.out.println(logoutMessgae.getText());
	}
}
