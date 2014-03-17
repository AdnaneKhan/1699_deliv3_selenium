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
	
	@When ("I want to change my password to \"(.*?)\"")
	public void change_pw(String newPw) {
		
	}
}
