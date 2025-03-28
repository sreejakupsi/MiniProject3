package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic.ProjectBasicMethods;

public class SearchAndCancel extends ProjectBasicMethods {

	WebDriver driver;

	@FindBy(xpath = " //a[contains(text(), 'Booked Itinerary')]")
	WebElement bookitineraryMenu;

	@FindBy(id = "order_id_text")
	WebElement searchOrderId;

	@FindBy(id = "order_id_1321616")
	WebElement firstOrderid;

	@FindBy(id = "search_hotel_id")
	WebElement goBtn;

	@FindBy(id = "btn_id_1322285")
	WebElement cancelBtn;

	// constructor
	public SearchAndCancel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// search order id
	public void searchOrderId() {
	    bookitineraryMenu.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    // Wait for the search input field to appear
	    WebElement searchField = wait.until(ExpectedConditions.visibilityOf(searchOrderId));

	    if (searchField.isDisplayed()) {
	        System.out.println("The search order ID text box is displayed");
	    } else {
	        System.out.println("The search order ID text box is NOT displayed");
	        return; // Exit if not found
	    }

	    // Re-locate firstOrderid after clicking menu (avoids StaleElementReferenceException)
	    WebElement firstOrderElement = wait.until(ExpectedConditions.visibilityOf(firstOrderid));

	    // Get order ID from attribute or text
	    String firstOrderIdValue = firstOrderElement.getAttribute("value");
	    if (firstOrderIdValue == null || firstOrderIdValue.isEmpty()) {
	        firstOrderIdValue = firstOrderElement.getText();
	    }

	    System.out.println("First Order ID: " + firstOrderIdValue);
	    
	    if (firstOrderIdValue.isEmpty()) {
	        System.out.println("No valid Order ID found!");
	        return;
	    }

	    // Enter the order ID and click the Go button
	    searchOrderId.sendKeys(firstOrderIdValue);
	    wait.until(ExpectedConditions.elementToBeClickable(goBtn)).click();
	}



	// cancel the hotel booked
	public String cancelHotel() {
		bookitineraryMenu.click();
		cancelBtn.click();

		// Explicite wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());

		// Alert message
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println("AlertMsg: " + alertMsg);
		alert.accept();
		return alertMsg;
	}
}
