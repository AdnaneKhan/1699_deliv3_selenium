package deliv3.testing;

import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class RunJForumTest {

}
