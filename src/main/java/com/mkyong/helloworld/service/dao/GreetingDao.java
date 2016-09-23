package com.mkyong.helloworld.service.dao;

import java.util.Locale;

public interface GreetingDao {
	public String getGreeting();

	public String getGreeting(Locale locale);
}
