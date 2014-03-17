
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
	LOG_IN (1,"//*[@id=\"login\"]"),
	U_NAME (2,"//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"),
	P_WORD (3,"//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"),
	SUBMIT (4,"//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td/input[2]"),
	// This is where we have locally installed Selenium
	WEB_HOME (5,"http://localhost:8080/jforum"),
	// 
	LOGGED_IN (6,"//*[@id=\"logout\"]"),
	MY_PROFILE(7,"http://localhost:8080/jforum/user/edit/2.page"),
	CUR_PASSWORD(8,"//*[@id=\"current_password\"]"),
	NEW_PASS(9,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input"),
	CONFIRM_PASS(10,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"),
	TWITTER_INPUT(11,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input"),
	TWITTER_ANCHOR(12,"/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[4]/td/table/tbody/tr/td/a[3]"),
	INVALID_LOGIN_WARNING(13,"//*[@id=\"invalidlogin\"]/font"),
	ADMIN_CP (14,"//*[@id=\"adminpanel\"]"),
	SIG_BLOCK(15,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[21]/td[2]/textarea"),
	SHOW_SIG_YES(16,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[29]/td[2]/input[1]"),
	SHOW_SIG_NO(17,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[29]/td[2]/input[2]"),
	SAVE_PROFILE(18,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[38]/td/input[1]"),
	PROFILE_FORUM_INDEX(19,"//*[@id=\"post\"]/table/tbody/tr/td/table/tbody/tr[1]/td[1]/span/a"),
	TEST_FORUM(20,"/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/span[1]/a"),
	INTRO_THREAD(21,"/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[2]/td[2]/span/a");
	
	private int id;
	private String name;
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString()
	{
		return this.name;
	}
	private Locators(int id, String name) {
		this.id = id;
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