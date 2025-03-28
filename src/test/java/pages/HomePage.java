package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basic.ProjectBasicMethods;

public class HomePage extends ProjectBasicMethods {

	WebDriver driver;
	
	@FindBy(xpath="//a[text()='New User Register Here']")
	WebElement registrationLink;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(className = "logo")
	WebElement logo;
	
	@FindBy(id="username_show")
	WebElement usernameWelcome;
	
	@FindBy(xpath=" //a[contains(text(), 'Search Hotel')]")
	WebElement searchHotelMenu;
	
	@FindBy(xpath=" //a[contains(text(), 'Booked Itinerary')]")
	WebElement bookitineraryMenu;
	
	@FindBy(xpath=" //a[contains(text(), 'Change Password')]")
	WebElement changepasswordMenu;
	
	@FindBy(xpath=" //a[contains(text(), 'Logout')]")
	WebElement logoutMenu;
	
	
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//checkif the register link is clickable
	public void clickRegister() {
		registrationLink.click();
	}
	
	//check if the login button is visible and clickable
	public void checkLoginBtn() {
		if(loginBtn.isDisplayed()&& loginBtn.isEnabled()) {
			System.out.println("The login button is visible and clickable");
		}
		else {
			System.out.println("The login button is NOT visible and clickable");
		}
	}
	
	//check if the home page is displayed correctly
	public void homepageDisplay() {
		if(logo.isDisplayed()) {
			System.out.println("The logo is displayed on the home screen");
		}
		if(usernameWelcome.isDisplayed()) {
			System.out.println("The username with hello message is displayed");
		}
		if(searchHotelMenu.isDisplayed()) {
			System.out.println("The search hotel menu is displayed");
		}
		if(bookitineraryMenu.isDisplayed()) {
			System.out.println("The booked itinerary menu is displayed");
		}
		if(changepasswordMenu.isDisplayed()) {
			System.out.println("The change password menu is displayed");
		}
		if(logoutMenu.isDisplayed()) {
			System.out.println("The logout menu is displayed");
		}
		else {
			System.out.println("The home page is not designed as expectede");
		}
	}
	
	
}
