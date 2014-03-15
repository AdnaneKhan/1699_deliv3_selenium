package deliv3.jforumtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import static org.junit.Assert.*;

/**
 * Step Definition File for 
 * 
 * 
 * Given I am a registered user
 *	and my username is TestUser
 *	and my password is test_pw
 *	When I try to log in
 *	and I enter TestUser
 *	and I enter test_pw
 *	Then I am given access to the site
 * 			Scenario: 
 * @author adnankhan
 *
 */
public class RegUserLoginStepDefinitions extends SeleniumSteps
{
	private String userName = null;
	private String userPass = null;
    
    public void setUp() {
    	super.setUp();
    }
    
    public void tearDown() {
    	super.tearDown();
    }	
    
    
    
    @Given ("my username is (.*)$")
    public void logUserIn(String uName) {
    	userName = uName;
    }
    
    @Given ("my password is (.*)$")
    public void enterPass(String pWord) {
    	userPass = pWord;
    }
    
    @When ("I try to log in")
    public void login() {
    	WebElement login = find(Locators.LOG_IN);
    	login.click();
    	
    	WebElement uname = find(Locators.U_NAME);
    	WebElement pass = find(Locators.P_WORD);
    	
    	uname.sendKeys(this.userName);
    	pass.sendKeys(this.userPass);
    	
    	WebElement submit = find(Locators.SUBMIT);
    	
    	submit.click();	
    }
    
    @Then ("I am granted access to the forum")
    public void verifyLogin() {
    	String regex = "\\[(.*?)\\]";
    	Pattern p = Pattern.compile(regex);
    	
    	WebElement loggedIn = find(Locators.LOGGED_IN);
    	String field = loggedIn.getText();
    	
    	Matcher m = p.matcher(field);
    	
    	assertEquals(m.group(1), this.userName);
    }
}
