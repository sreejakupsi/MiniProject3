package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelSearchPage {

	WebDriver driver;
	
	@FindBy(id="Submit")
	WebElement searchBtn;
	
	@FindBy(xpath=" //a[contains(text(), 'Search Hotel')]")
	WebElement searchHotelMenu;
	
	@FindBy(id="Reset")
	WebElement resetBtn;
	
	//constructor
	public HotelSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//search hotel with valid credientials
	public void validHotelSearch(String checkindate,String checkoutdate) {
		
		//location dropdown
		WebElement locationDropdown= driver.findElement(By.id("location"));
		Select locationselect=new Select(locationDropdown);
		locationselect.selectByVisibleText("Brisbane");
		
		//hotel dropdown
		WebElement hotelDropdown=driver.findElement(By.id("hotels"));
		Select hotelselect=new Select(hotelDropdown);
		hotelselect.selectByIndex(2);
		
		//room type
		WebElement roomtypeDropdown =driver.findElement(By.id("room_type"));
		Select roomtypeselect= new Select(roomtypeDropdown);
		roomtypeselect.selectByValue("Standard");
		
		//number of rooms
		WebElement noOfroomsDropdown =driver.findElement(By.id("room_nos"));
		Select roomnoselect =new Select(noOfroomsDropdown);
		roomnoselect.selectByVisibleText("2 - Two");
		
		 driver.findElement(By.id("datepick_in")).sendKeys(checkindate);
		 driver.findElement(By.id("datepick_out")).sendKeys(checkoutdate);
	
		
		
		//adult room
		WebElement adultroomDropdown= driver.findElement(By.id("adult_room"));
		Select adultroomselect =new Select(adultroomDropdown);
		adultroomselect.selectByValue("2");
		
		//children per room
		WebElement childernroomDropdown= driver.findElement(By.id("child_room"));
		Select childrenroomselect= new Select(childernroomDropdown);
		childrenroomselect.selectByVisibleText("1 - One");
		
		searchBtn.click();
		System.out.println("The values are filled and the page is redirected");
		
	}	
}
