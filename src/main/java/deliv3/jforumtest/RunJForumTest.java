package deliv3.jforumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class RunJForumTest {

}
