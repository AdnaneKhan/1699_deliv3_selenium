package deliv3.testing;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;
import static org.junit.Assert.*;

/**
 * This class handles initialization of the Selenium driver used for step defs provides an accesor for xPath locator handles
 * 
 * @author adnankhan
 *
 */

public class SeleniumSteps {
	
	protected static String userName = null;
	protected static String userPass = null;
	
	SeleniumSteps() {
		getCurrentDriver();
	}
	/**
	 * WebDriver in which our steps will be executed
	 */
	protected static WebDriver testDriver = null;

	protected synchronized static void tearDown() {
		userName = null;
		userPass = null;
		testDriver.quit();
		testDriver = null;
	}
	
	public synchronized static WebDriver getCurrentDriver() {
		if (testDriver == null) {
				testDriver = new FirefoxDriver();
				testDriver.get(Locators.WEB_HOME.getName());
		}
		return testDriver;
	}

	protected WebElement find(Locators handle) {
		return this.find(handle, getCurrentDriver());
	}
	
	protected WebElement find(Locators handle, WebDriver specific) {
		WebElement toFind = null;
		
		try {
			toFind = specific.findElement(By.xpath(handle.getName()));
		} catch (NoSuchElementException e ) {
			tearDown();
			fail("Element Not Located!!!");
		}
		
		return toFind;
	}
	
	protected boolean present(Locators handle) {
		try {
			testDriver.findElement(By.xpath(handle.getName()));
		} catch (NoSuchElementException e ) {
			return false;
		}
		return true;
	}
	
	
	protected void takeScreen(WebDriver screentaker, String savePath) throws IOException {
		File screen = ((TakesScreenshot)screentaker).getScreenshotAs(OutputType.FILE);
		
		org.apache.commons.io.FileUtils.copyFile(screen, new File(savePath));
	}
}
