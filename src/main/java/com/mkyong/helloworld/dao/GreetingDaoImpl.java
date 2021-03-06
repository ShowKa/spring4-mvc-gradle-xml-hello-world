package com.mkyong.helloworld.dao;

import java.util.Locale;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.GreetingDao;

@Component
public class GreetingDaoImpl implements GreetingDao {

	@Override
	public String getGreeting() {
		return "Hello";
	}

	@Override
	public String getGreeting(Locale locale) {

		if (locale.equals(Locale.JAPAN)) {
			return "Konnichiha";
		} else if (locale.equals(Locale.CHINA)) {
			return "Nihao";
		} else if (locale.equals(Locale.FRANCE)) {
			return "Bon Jour";
		} else {
			return "Hello";
		}
	}
}
