package deliv3.jforumtest;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import static org.junit.Assert.*;


/**
 * Step Definition File
 * 
 * @author adnankhan
 *
 */
public class UserPostStepDefinitions
{
	
	private WebDriver testDriver;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    private String userName;
    private String userPass;
    
    
    public void setUp() {
    	testDriver = new FirefoxDriver();
    	testDriver.get(Locators.WEB_HOME.getName());
    }
    
    @Given ("my username is (.*)$")
    public void logUserIn(String uName) {
    	userName = uName;
    }
    
    @Given ("my password is (.*)$")
    public void enterPass(String pWord) {
    	userPass = pWord;
    }
    
    @When ("i try to log in")
    public void login() {
    	WebElement login = find(Locators.LOG_IN);
    	login.click();
    	
    	WebElement uname = find(Locators.U_NAME);
    	WebElement pass = find(Locators.P_WORD);
    	
    	uname.sendKeys(this.userName);
    	pass.sendKeys(this.userPass);
    	
    	WebElement submit = find(Locators.SUBMIT);
    	
    	submit.click();	
    }
    
    @Then ("I am granted access to the forum")
    public void verifyLogin() {
    	String regex = "\\[(.*?)\\]";
    	Pattern p = Pattern.compile(regex);
    	
    	
    	WebElement loggedIn = find(Locators.LOGGED_IN);
    	String field = loggedIn.getText();
    	
    	Matcher m = p.matcher(field);
    	
    	assertEquals(m.group(1), this.userName);
    }
    
    public void tearDown() {
    	this.testDriver.close();
    }
    
    private WebElement find(Locators handle) {
    	return this.testDriver.findElement(By.xpath(handle.getName()));
    }
    		
}
