package deliv3.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

public class PostStepDefinitions extends SeleniumSteps {
	public PostStepDefinitions() {
		super();
	}
	
	public void tearDown() {
		super.tearDown();
	}
}
