package deliv3.testing;

import org.openqa.selenium.By;
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
	
	protected void takeScreen(WebDriver screentaker, String savePath) throws IOException {
		File screen = ((TakesScreenshot)screentaker).getScreenshotAs(OutputType.FILE);
		
		org.apache.commons.io.FileUtils.copyFile(screen, new File(savePath));
	}
	
}
