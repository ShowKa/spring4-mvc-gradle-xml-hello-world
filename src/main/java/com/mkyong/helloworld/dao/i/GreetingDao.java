package com.mkyong.helloworld.dao.i;

import java.util.Locale;

public interface GreetingDao {
	public String getGreeting();

	public String getGreeting(Locale locale);
}
