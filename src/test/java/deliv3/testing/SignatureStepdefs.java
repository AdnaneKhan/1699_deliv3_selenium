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

//Scenario: Add A Signature
//	Given I am a registered user
//And my username is "TestUser"
//And my password is "test_pw"
//When I try to log in
//And I edit my profile
//And I set my Signature to "I am the ruler of the board"
//And then set my signature to attach
//And I submit my changes
//Then my signature should appear below posts that I have made
//And I close my browser

public class SignatureStepdefs extends SeleniumSteps {
	public SignatureStepdefs() {
		super();
	}
	
	@And ("I set my Signature to \"(.*?)\"")
	public void I_set_my_Signature_to(String sign){
		WebElement sigBlock = find(Locators.SIG_BLOCK);
		sigBlock.clear();
		sigBlock.sendKeys(sign);
	}
	
	@And ("then set my signature to attach")
	public void then_set_my_signature_to_attch(){
		WebElement attachButton = find(Locators.SHOW_SIG_YES);
		attachButton.click();
	}
	
	@Then ("my signature should appear below posts that I have made")
	public void my_signature_should_appear_below_posts_that_I_have_made(){
		assertTrue(present(Locators.PROF_UPDATE));
		
		WebElement userList = find(Locators.MEM_LIST);
		userList.click();
		
		super.getCurrentDriver().findElement(By.linkText(super.userName)).click();
	}
}