package deliv3.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

//Given that I am an admin
//when I make a post restricted to admins only
//and a non-administrator views the forum
//then the user is unable to see the restricted thread

@RunWith(Cucumber.class)
public class PostAccessRestStepDefs extends SeleniumSteps {
	// We utilize a separate instance of webdriver to serve as the admin's browsers
	private WebDriver adminDriver = new FirefoxDriver();
	private static final String ADMIN_PW = "1699_pw";
	private static final String ADMIN_NAME = "Admin";

	public void setUp() {
		super.setUp();
		adminDriver.get(Locators.WEB_HOME.getName());
		
		// Log the admin in, not part of test, but if it fails we abort
		
		
		// Logged in? good
	}
	
	@Given ("that I am an admin.")
	public void adminLogin() {
		//Locate and click login page

		super.find(Locators.LOGGED_IN,adminDriver).click();
		super.find(Locators.U_NAME,adminDriver).sendKeys(this.ADMIN_NAME);
		super.find(Locators.P_WORD,adminDriver).sendKeys(this.ADMIN_PW);	
		super.find(Locators.SUBMIT,adminDriver).click();
		
		// Verify that we are logged in and that we are admin
		
	}
	
	@When ("I make a thead named (.?) viewable by admins only")
	public void restricted() {
		// Make a post & set it to be restricted
	}
	
	@When ("a non-administrator views the forum")
	public void nonAdminView() {
		// initilize the user webdriver
		// log in the user
		// make sure user is not admin
		
		// attempt to view the thread
		// this will be done by getting the container of the forum
		// and then searching post elements for the previous name
		
	}
	
	@Then ("the user is unable to see the restricted thread")
	public void confirmRestriction() {
		
	}
	
	
	public void tearDown() {
		super.tearDown();
		adminDriver.close();
	}
}
