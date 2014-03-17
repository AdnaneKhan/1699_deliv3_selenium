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

public class AdminUserLoginStepDefs extends SeleniumSteps{
	
	private String userName = null;
	private String userPass = null;
	
	@Given("^that I am a forum administrator$")
	public void that_I_am_a_forum_administrator() throws Throwable {
	   
	}

	@Then("^I am able to access the control panel$")
	public void I_am_able_to_access_the_control_panel() throws Throwable {
		WebElement admin_cp = super.find(Locators.ADMIN_CP);
		
		String admin_text = "Admin Control Panel";
		assertEquals(admin_text,admin_cp.getText());
	}
}
