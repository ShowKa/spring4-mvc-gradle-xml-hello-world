package com.mkyong.helloworld.service.dao.mock;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.mockito.stubbing.OngoingStubbing;

import com.mkyong.helloworld.service.dao.TitleDao;

import mockit.Expectations;

public class TitleDaoMockSetter {

	public static final String JAPANESE_GREETING = "Konnichiha";
	public static final String CHINESE_GREETING = "Nihao";
	public static final String FRENCH_GREETING = "BonJour";
	public static final String ENGLISH_GREETING = "Hello";

	// Mockito
	public static OngoingStubbing<String> returnJapaneseGreeting(TitleDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(JAPANESE_GREETING);
	}

	public static OngoingStubbing<String> returnChineseGreeting(TitleDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(CHINESE_GREETING);
	}

	public static OngoingStubbing<String> returnFrenchGreeting(TitleDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(FRENCH_GREETING);
	}

	public static OngoingStubbing<String> returnEnglishGreeting(TitleDao titleDao) {
		return when(titleDao.getGreeting((Locale) anyObject())).thenReturn(ENGLISH_GREETING);
	}

	// JMockit
	public static Expectations expectJapaneseGreeting(TitleDao titleDao) {
		return new Expectations() {
			{
				titleDao.getGreeting(Locale.JAPAN);
				result = JAPANESE_GREETING;
			}
		};
	}

	public static Expectations expectChineseGreeting(TitleDao titleDao) {
		return new Expectations() {
			{
				titleDao.getGreeting(Locale.CHINA);
				result = CHINESE_GREETING;
			}
		};
	}
}
