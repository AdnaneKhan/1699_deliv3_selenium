
package deliv3.testing;

import cucumber.api.junit.*;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum holds all of the locators for our jforum test in their xPath formats.
 * 
 * These xPaths were acquired using the Inspect Element -> Copy xPath feature in Google Chrome
 * @author adnankhan
 *
 */
public enum Locators {
	LOG_IN ("//*[@id=\"login\"]"),
	U_NAME ("//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"),
	P_WORD ("//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"),
	SUBMIT ("//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td/input[2]"),
	// This is where we have locally installed Selenium
	WEB_HOME ("http://localhost:8080/jforum"),
	// 
	LOGGED_IN ("//*[@id=\"logout\"]"),
	MY_PROFILE("//*[@id=\"myprofile\"]"),
	CUR_PASSWORD("//*[@id=\"current_password\"]"),
	NEW_PASS("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input"),
	CONFIRM_PASS("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"),
	TWITTER_INPUT("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input"),
	TWITTER_ANCHOR("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[4]/td/table/tbody/tr/td/a[3]"),
	INVALID_LOGIN_WARNING("//*[@id=\"invalidlogin\"]/font"),
	ADMIN_CP ("//*[@id=\"adminpanel\"]"),
	INFO_UPDATE ("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[1]/td/span/b/font"),
	SHOW_SIG_YES("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[29]/td[2]/input[1]"),
	SHOW_SIG_NO("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[29]/td[2]/input[2]"),
	SAVE_PROFILE("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[38]/td/input[1]"),
	PROFILE_FORUM_INDEX("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[1]/td[1]/span/a"),
	TEST_FORUM("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/span[1]/a"),
	INTRO_THREAD("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[2]/td[2]/span/a"),
	PW_CONF1 ("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input"),
	PW_CONF2 ("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"),
	SUBMIT_CHANGES ( "//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[39]/td/input[1]"),
	INFO_WRONG ( "\"post\"]/table/tbody/tr/td/table/tbody/tr[1]/td/span/b/font"),
	SUBMIT_SETTINGS("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[38]/td/input[1]"),
	OLD_PW("//*[@id=\"current_password\"]"),
	SIG_BLOCK("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[21]/td[2]/textarea"),
	ADMIN_NAME("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[4]/tbody/tr[3]/td/a/span"),
	MEM_LIST("//*[@id=\"userlist\"]"),
	PROF_UPDATE("//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[1]/td/span/b/font"),
	TWITTER("/html/body/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/b/span/a");

	private String name;
	
	
	public String getName() {
		return this.name;
	}
	
	public String toString()
	{
		return this.name;
	}
	private Locators( String name) {
		this.name = name;
	}
	
	private static final Map<String, Locators> lookupName = new HashMap<String, Locators>();

	static {
		for (Locators s : EnumSet.allOf(Locators.class))
			lookupName.put(s.getName(), s);
	}

	public static Locators get(String name) throws Exception {
		Locators retV = null;
		retV = lookupName.get(name);
		if (retV == null) {
			throw new Exception();
		}
		return retV;
	}
}