package deliv3.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.*;
import static org.junit.Assert.*;

public class TwitterHandleStepdefs extends SeleniumSteps {
	public TwitterHandleStepdefs() {
		super();
	}
	
	public void closeDown() {
		super.tearDown();
	}

	private String twitterHandle;
	
	@And ("I edit my profile")
	public void I_edit_my_profile() throws InterruptedException{
		super.getCurrentDriver().findElement(By.linkText("My Profile")).click();
	}

	@And("I want to change my Twitter account to \"(.*?)\"")
	public void change_pw(String twtAccount) throws InterruptedException {
		this.twitterHandle = twtAccount;
		
		WebElement twtBox = super.find(Locators.TWITTER_INPUT);
		twtBox.clear();
		twtBox.sendKeys(twtAccount);
	}
	
	@And("I submit my changes")
	public void submitChanges() throws InterruptedException{
		WebElement submitButton = super.find(Locators.SAVE_PROFILE);
		submitButton.click();
	}

	@Then("my twitter handle should appear below posts that I have made")
	public void confirmHandle() throws InterruptedException {
		// Make sure handle matches the one we entered earlier

		String purportedLink = "http://twitter.com/" + this.twitterHandle;
		
		assertTrue(present(Locators.PROF_UPDATE));
		
		WebElement userList = find(Locators.MEM_LIST);
		userList.click();
		
		super.getCurrentDriver().findElement(By.linkText(super.userName)).click();
		
		String twitterLink = find(Locators.TWITTER).getAttribute("href");
		
		assertEquals(twitterLink.equals(purportedLink),true);
	}

}
