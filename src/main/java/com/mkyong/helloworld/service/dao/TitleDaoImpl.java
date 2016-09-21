package com.mkyong.helloworld.service.dao;

import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class TitleDaoImpl implements TitleDao {

	@Override
	public String getGreeting() {
		return "Hello";
	}

	@Override
	public String getGreeting(Locale locale) {
		if (locale.equals(Locale.JAPAN)) {
			return "Konnichiha";
		} else {
			return "Hello";
		}
	}
}
