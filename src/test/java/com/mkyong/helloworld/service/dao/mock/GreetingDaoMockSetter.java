package com.mkyong.helloworld.service.dao.mock;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.mockito.stubbing.OngoingStubbing;

import com.mkyong.helloworld.dao.i.GreetingDao;

import mockit.Expectations;

public class GreetingDaoMockSetter {

	public static final String JAPANESE_GREETING = "Konnichiha";
	public static final String CHINESE_GREETING = "Nihao";
	public static final String FRENCH_GREETING = "BonJour";
	public static final String ENGLISH_GREETING = "Hello";

	// Mockito
	public static OngoingStubbing<String> returnJapaneseGreeting(GreetingDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(JAPANESE_GREETING);
	}

	public static OngoingStubbing<String> returnChineseGreeting(GreetingDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(CHINESE_GREETING);
	}

	public static OngoingStubbing<String> returnFrenchGreeting(GreetingDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(FRENCH_GREETING);
	}

	public static OngoingStubbing<String> returnEnglishGreeting(GreetingDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(ENGLISH_GREETING);
	}

	// JMockit
	public static Expectations expectJapaneseGreeting(GreetingDao titleDao) {
		return new Expectations() {
			{
				titleDao.getGreeting(Locale.JAPAN);
				result = JAPANESE_GREETING;
			}
		};
	}

	public static Expectations expectChineseGreeting(GreetingDao titleDao) {
		return new Expectations() {
			{
				titleDao.getGreeting(Locale.CHINA);
				result = CHINESE_GREETING;
			}
		};
	}
}
