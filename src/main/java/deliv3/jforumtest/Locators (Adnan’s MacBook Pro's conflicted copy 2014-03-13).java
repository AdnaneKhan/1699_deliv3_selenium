
package deliv3.jforumtest;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Locators {
	LOG_IN (1,"//*[@id=\"login\"]"),
	U_NAME (2,"//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"),
	P_WORD (3,"//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"),
	SUBMIT (4,"//*[@id=\"loginform\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td/input[2]"),
	LOGGED_IN (5, "//*[@id=\"logout\"]");
	
	private int id;
	private String name;
	private boolean needOutput;
	
	public int getId() {
		return this.id;
	}
	
	public boolean writesOut() {
		return this.needOutput;
	}
	public String getName() {
		return this.name;
	}
	
	private Locators(int id, String name) {
		this(id,name,false);
	}
	
	private Locators(int id, String name, boolean lookup) {
		this.id = id;
		this.name = name;
		this.needOutput = lookup;
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