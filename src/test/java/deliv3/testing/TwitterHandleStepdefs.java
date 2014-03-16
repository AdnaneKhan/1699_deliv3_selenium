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

@RunWith(Cucumber.class)
public class TwitterHandleStepdefs extends SeleniumSteps {
	public void setUp() {
		super.setUp();
	}

	public void tearDown() {
		super.tearDown();
	}

	private String uName;
	private String pWord;
	private String twitterHandle;

	//
	// Scenario: User Twitter Handle
	@Given("that I am a user with the user name (.$)")
	public void setUName(String userName) {
		this.uName = userName;
	}

	@And("my password is (.$)")
	public void setPW(String passWord) {
		this.pWord = passWord;
	}

	@And("I log log in")
	public void logIn() {
		// login
	}

	@When("I edit my profile")
	public void editprofile() {
		// click on the profile edit button
	}

	@And("I set my twitter handle as (.?)")
	public void saveChanges(String twitter) {
		this.twitterHandle = twitter;

		// look for some element that indicates that the changes have been saved
	}

	@Then("my twitter handle should appear below posts that I have made")
	public void confirmHandle() {
		// Make sure handle matches the one we entered earlier
		WebElement handle = super.find(Locators.TWITTER_ANCHOR);
		String linkText = super.find(Locators.TWITTER_ANCHOR).getAttribute(
				"href");
		String purportedLink = "http://twitter.com/" + this.twitterHandle;

		// String[] explodeURL = linkText.split("/");
		// int index = (explodeURL.length-1);
		// String purportedName = explodeURL[index];
		assertEquals(purportedLink, this.twitterHandle);
	}

}
