package deliv3.jforumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import static org.junit.Assert.*;

/**
 * This class handles initialization of the Selenium driver used for step defs provides an accesor for xPath locator handles
 * 
 * @author adnankhan
 *
 */
public class SeleniumSteps {
	
	/**
	 * WebDriver in which our steps will be executed
	 */
	protected WebDriver testDriver;

	protected void setUp() {
		testDriver = new FirefoxDriver();
		testDriver.get(Locators.WEB_HOME.getName());
	}

	protected void tearDown() {
		this.testDriver.close();
	}

	protected WebElement find(Locators handle) {
		return this.testDriver.findElement(By.xpath(handle.getName()));
	}
}
