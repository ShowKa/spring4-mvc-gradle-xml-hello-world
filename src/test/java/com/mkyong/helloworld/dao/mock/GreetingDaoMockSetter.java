package com.mkyong.helloworld.dao.mock;

import static com.mkyong.helloworld.entity.GreetingCatalog.CHINESE_GREETING;
import static com.mkyong.helloworld.entity.GreetingCatalog.ENGLISH_GREETING;
import static com.mkyong.helloworld.entity.GreetingCatalog.FRENCH_GREETING;
import static com.mkyong.helloworld.entity.GreetingCatalog.JAPANESE_GREETING;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.mockito.stubbing.OngoingStubbing;

import com.mkyong.helloworld.dao.i.GreetingDao;

import mockit.Expectations;

public class GreetingDaoMockSetter {

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
