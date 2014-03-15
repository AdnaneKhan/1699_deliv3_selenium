
package deliv3.jforumtest;

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
	WEB_HOME (5,"http://localhost:8080/jforum"),
	LOGGED_IN (6,"//*[@id=\"logout\"]");
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