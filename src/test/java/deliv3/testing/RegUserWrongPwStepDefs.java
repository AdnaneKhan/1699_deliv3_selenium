package deliv3.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

public class RegUserWrongPwStepDefs extends SeleniumSteps {
	@Given("^my correct password is \"([^\"]*)\"$")
	public void my_correct_password_is(String arg1) throws Throwable {
		
	}

	@Given("^instead I enter \"([^\"]*)\"$")
	public void instead_I_enter(String arg1) throws Throwable {
		WebElement login = find(Locators.LOG_IN);
    	login.click();
    	
    	WebElement uname = find(Locators.U_NAME);
    	WebElement pass = find(Locators.P_WORD);
    	
    	uname.sendKeys(this.userName);
    	pass.sendKeys(this.userPass);
    	
    	WebElement submit = find(Locators.SUBMIT);
    	
    	submit.click();	
	}
	
	@Then("^I am notified that my login was invalid$")
	public void I_am_notified_that_my_login_was_invalid() throws Throwable {
	   assertTrue(super.present(Locators.INVALID_LOGIN_WARNING));
	}

	@Then("^I am not given access to the site$")
	public void I_am_not_given_access_to_the_site() throws Throwable {
		assertFalse(super.present(Locators.LOGGED_IN));
	}

}
