package deliv3.testing;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.*;

import static org.junit.Assert.*;

public class TwitterHandleStepdefs extends SeleniumSteps {
	public TwitterHandleStepdefs() {
		super();
	}
	
//	  Scenario: User Twitter Handle
//	    Given that I am a user
//	    And my username is "Admin"
//	    And my password is "1699_pw"
//	    When I edit my profile
//	    And I set my Twitter handle as "user1"
//	    And then save these changes
//	    Then my twitter handle should appear below posts that I have made
//	    And I close my browser

	public void closeDown() {
		super.tearDown();
	}

	private String twitterHandle;

	@When("^I edit my profile")
	public void editprofile() {
		WebElement myProfile = find(Locators.MY_PROFILE);
		myProfile.click();
	}

	@And("I set my twitter handle as \"(.*?)\"$")
	public void saveChanges(String twitter) {
		WebElement twitterBox = super.find(Locators.TWITTER_INPUT);
		twitterBox.sendKeys(twitter);
	}
	
	@And("I submit my changes")
	public void submitChanges(){
		WebElement submitButton = super.find(Locators.SAVE_PROFILE);
		submitButton.click();
	}

	@Then("my twitter handle should appear below posts that I have made")
	public void confirmHandle() {
		// Make sure handle matches the one we entered earlier
		WebElement homeButton = super.find(Locators.PROFILE_FORUM_INDEX);
		homeButton.click();
		
		WebElement testForum = super.find(Locators.TEST_FORUM);
		testForum.click();
		
		WebElement welcomeForum = super.find(Locators.INTRO_THREAD);
		welcomeForum.click();
		
		WebElement handle = super.find(Locators.TWITTER_ANCHOR);
		String linkText = super.find(Locators.TWITTER_ANCHOR).getAttribute(
				"href");
		String purportedLink = "http://twitter.com/" + this.twitterHandle;

		assertEquals(purportedLink, this.twitterHandle);
	}

}
