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
	// To be used for holding the new password
	private static String temp_new_pw = null;

	@When("I want to change my password to \"(.*?)\"")
	public void change_pw(String newPw) {
		temp_new_pw = newPw;

		WebElement settings = find(Locators.MY_PROFILE);
		settings.click();

		WebElement pw_field = super.find(Locators.PW_CONF1);
		WebElement pw_field2 = super.find(Locators.PW_CONF2);
		pw_field.sendKeys(temp_new_pw);
		pw_field2.sendKeys(temp_new_pw);
		temp_new_pw = null;

	}

	@Then("^my old password of \"([^\"]*)\" does not work$")
	public void my_old_password_of_does_not_work(String arg1) throws Throwable {
		WebElement login = find(Locators.LOG_IN);
		login.click();

		WebElement uname = find(Locators.U_NAME);
		WebElement pass = find(Locators.P_WORD);

		uname.sendKeys(this.userName);
		pass.sendKeys(arg1);

		WebElement submit = find(Locators.SUBMIT);

		submit.click();

		assertFalse(super.present(Locators.LOGGED_IN));
	}

	@When("^I am asked to enter my old password I enter \"(.*?)\"$")
	public void I_am_asked_to_enter_my_old_password_I_enter(String old_password)
			throws Throwable {
		WebElement old_pw = super.find(Locators.OLD_PW);

		old_pw.sendKeys(old_password);
	}

	@Then("^my password change is rejected$")
	public void my_password_change_is_rejected() throws Throwable {
		WebElement submitButton = super.find(Locators.SAVE_PROFILE);
		submitButton.click();

		assertTrue(super.present(Locators.WRONG_PW));
	}

	@When("^I am asked to confirm the new password I enter \"([^\"]*)\"$")
	public void I_am_asked_to_confirm_the_new_password_I_enter(String arg1)
			throws Throwable {

		WebElement pw_field = super.find(Locators.PW_CONF1);
		WebElement pw_field2 = super.find(Locators.PW_CONF2);
		pw_field2.clear();
		pw_field2.sendKeys(arg1);

		WebElement click_sub = super.find(Locators.SUBMIT_SETTINGS);

		click_sub.click();
		
		super.handleAlerts();
	}

	@When("^I log out$")
	public void I_log_out() throws Throwable {
		WebElement logout = super.find(Locators.LOGGED_IN);
		logout.click();

		// We check that the login prompt is present because we should have
		// logged out
		assertTrue(super.present(Locators.LOG_IN));
	}
}
