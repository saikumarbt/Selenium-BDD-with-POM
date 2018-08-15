package com.suntaragali.freecrm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suntaragali.freecrm.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//Initialize the Page Objects	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions - Features	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		//loginBtn.submit();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}
