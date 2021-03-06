package com.enrico200165.utils.html;

import org.apache.log4j.*;

import java.util.ArrayList;


public class Attributoid implements IHTMLContent {

	Attributoid(String name, String value) {
		this.name = name;
		values = new ArrayList<String>();
		values.add(value);
	}

	@Override
	public String getHTMLMarkUp(int level) {
		String ret = this.name+"=\"";
		for (String s: this.values) {
			ret+=s;
		}
		ret+="\"";
		return ret;
	}

	public void addValue(String val) {
		values.add(val);
	}

	String name;
	ArrayList<String> values;
	private static org.apache.log4j.Logger log = Logger.getLogger(Attributoid.class);

}
