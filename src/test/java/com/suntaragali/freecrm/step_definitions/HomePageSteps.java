package com.suntaragali.freecrm.step_definitions;

import com.suntaragali.freecrm.base.TestBase;
import com.suntaragali.freecrm.pages.HomePage;
import com.suntaragali.freecrm.pages.LoginPage;
import com.suntaragali.freecrm.util.TestUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class HomePageSteps extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	@Before
	public void setUp() {
		TestBase.initialization();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() {
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Then("^user logs into FreeCRM$")
	public void user_types_username_and_password() {
		System.out.println(prop.getProperty("username"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Then("^validate homepage title$")
	public void validate_homepage_title() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}

	@Then("^validate logged in username$")
	public void validate_logged_in_username() {
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		boolean flag = homePage.verifyCorrectUsername();
		Assert.assertTrue(flag);
	}

}
