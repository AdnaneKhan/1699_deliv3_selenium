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

//Scenario: Hide my signature
//Given  I am a registered user
//And my username is "Admin"
//And my password is "1699_pw"
//When I try to log in
//When I edit my profile
//And disable attaching of my signature
//And I submit my changes
//Then no longer should my signature appear beneath posts I have participated in
//And I close my browser

public class SignatureStepdefs extends SeleniumSteps {
	String sigContent;
	public SignatureStepdefs() {
		super();
	}
	
	@And ("I set my Signature to \"(.*?)\"")
	public void I_set_my_Signature_to(String sign){
		sigContent = sign;
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
	public void my_signature_should_appear_below_posts_that_I_have_made() throws InterruptedException{
		assertTrue(present(Locators.PROF_UPDATE));
		
		WebElement userList = find(Locators.MEM_LIST);
		userList.click();
		
		super.getCurrentDriver().findElement(By.linkText(super.userName)).click();

		super.getCurrentDriver().findElement(By.partialLinkText("Messages posted by "+super.userName)).click();
		
		super.getCurrentDriver().findElement(By.linkText("Go to message")).click();
		
		WebElement signatureBlock = find(Locators.ADMIN_SIG_BLOCK);
		
		assertTrue(signatureBlock.getText().equalsIgnoreCase(sigContent));
		
		Thread.sleep(3000);
	}
	
	@And ("disable attaching of my signature")
	public void disable_attaching_of_my_signature(){
		WebElement attachButton = find(Locators.SHOW_SIG_NO);
		attachButton.click();
	}
	
	@Then ("no longer should my signature appear beneath posts I have participated in")
	public void no_longer_should_my_signature_appear_beneath_posts_I_have_participated_in(){
		assertTrue(present(Locators.PROF_UPDATE));
		
		WebElement userList = find(Locators.MEM_LIST);
		userList.click();
		
		super.getCurrentDriver().findElement(By.linkText(super.userName)).click();

		super.getCurrentDriver().findElement(By.partialLinkText("Messages posted by "+super.userName)).click();
		
		super.getCurrentDriver().findElement(By.linkText("Go to message")).click();
		
		//WebElement signatureBlock = find(Locators.ADMIN_SIG_BLOCK);
		
		assertFalse(present(Locators.ADMIN_SIG_BLOCK));
		
	}
}