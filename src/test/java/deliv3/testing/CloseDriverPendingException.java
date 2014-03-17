package deliv3.testing;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;

public class CloseDriverPendingException extends PendingException {
	 CloseDriverPendingException(WebDriver web) {
		 web.close();
	 }
}
