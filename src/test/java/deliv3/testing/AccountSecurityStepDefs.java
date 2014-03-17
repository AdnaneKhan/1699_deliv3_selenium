package deliv3.testing;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class AccountSecurityStepDefs extends SeleniumSteps {

	@When("I want to change my password to \"(.*?)\"")
	public void change_pw(String newPw) {

	}

	@Then("^my old password of \"([^\"]*)\" does not work$")
	public void my_old_password_of_does_not_work(String arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I am asked to enter my old password I enter \"([^\"]*)\"$")
	public void I_am_asked_to_enter_my_old_password_I_enter(String arg1)
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^my password change is rejected$")
	public void my_password_change_is_rejected() throws Throwable {
		// Express the Regexp above with the code you wish you had
		 assertTrue(super.present(Locators.INFO_WRONG));
	}

	@When("^I am asked to confirm the new password I enter \"([^\"]*)\"$")
	public void I_am_asked_to_confirm_the_new_password_I_enter(String arg1)
			throws Throwable {
		WebElement old_pw = super.find(Locators.OLD_PW);
		old_pw.sendKeys(super.userPass);
		
		WebElement pw_field = super.find(Locators.PW_CONF1);
		WebElement pw_field2 = super.find(Locators.PW_CONF2);
		pw_field.sendKeys(arg1);
		pw_field2.sendKeys(arg1);
		
		WebElement click_sub = super.find(Locators.SUBMIT_SETTINGS);
		click_sub.click();
	}

}
