package deliv3.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

public class AdminUserLoginStepDefs extends SeleniumSteps{
	
	private String userName = null;
	private String userPass = null;
	
	@Given("^that I am a forum administrator$")
	public void that_I_am_a_forum_administrator() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		throw new CloseDriverPendingException(super.testDriver);
	}
	
//    @And ("my username is \"(.*?)\"$")
//    public void logUserIn(String uName) {
//    	userName = uName;
//    }
//    
//    @And ("my password is \"(.*?)\"$")
//    public void enterPass(String pWord) {
//    	userPass = pWord;
//    }
//    
//    @When ("I try to log in 1")
//    public void loginAdmin() {
//    	WebElement login = find(Locators.LOG_IN);
//    	login.click();
//    	
//    	WebElement uname = find(Locators.U_NAME);
//    	WebElement pass = find(Locators.P_WORD);
//    	
//    	uname.sendKeys(this.userName);
//    	pass.sendKeys(this.userPass);
//    	
//    	WebElement submit = find(Locators.SUBMIT);
//    	
//    	submit.click();	
//    }

	@And ("^my login is accepted$")
	public void my_login_is_accepted() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		throw new CloseDriverPendingException(super.testDriver);
	}

	@Then("^I am able to access the control panel$")
	public void I_am_able_to_access_the_control_panel() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		throw new CloseDriverPendingException(super.testDriver);
	}
}
