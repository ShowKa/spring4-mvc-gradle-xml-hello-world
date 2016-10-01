package com.mkyong.helloworld.entity;

public class CountryCatalog {
	public static Country JAPAN = new Country();
	static {
		JAPAN.country_id = 50;
		JAPAN.country = "Japan";
	}

	public static Country CHINA = new Country();
	static {
		CHINA.country_id = 23;
		CHINA.country = "China";
	}

	public static Country FRANCE = new Country();
	static {
		FRANCE.country_id = 34;
		FRANCE.country = "France";
	}
}
