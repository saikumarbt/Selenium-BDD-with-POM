
package com.suntaragali.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suntaragali.freecrm.base.TestBase;

public class HomePage extends TestBase{

	//@FindBy(xpath="//td[contains(text(), 'User: Sai Kumar')]")
	@FindBy(xpath="//td[@class = 'headertext']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	//Initialize the Page Objects	
		public HomePage() {
			PageFactory.initElements(driver, this);
			
		}
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUsername() {
			return userNameLabel.isDisplayed();
		}
		public ContactsPage clickOnContactsLink() {
			contactLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink() {
			contactLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink() {
			contactLink.click();
			return new TasksPage();
		}
		
		public void clickOnNewContactLink() {
			Actions action = new Actions(driver);
			action.moveToElement(contactLink).build().perform();
			newContactLink.click();			
		}
	
}
