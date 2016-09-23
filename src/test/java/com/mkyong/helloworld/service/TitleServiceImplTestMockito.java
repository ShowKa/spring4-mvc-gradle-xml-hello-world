package com.mkyong.helloworld.service;

import java.util.Locale;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mkyong.helloworld.TestCaseBase;
import com.mkyong.helloworld.service.dao.GreetingDao;
import com.mkyong.helloworld.service.dao.mock.GreetingDaoMockSetter;
import com.mkyong.helloworld.service.entity.UserEntity;

public class TitleServiceImplTestMockito extends TestCaseBase {

	@InjectMocks
	private TitleServiceImpl titleService = new TitleServiceImpl();

	@Mock
	private GreetingDao greetingDao;

	@Test
	public void testGetDefaultTitle() {
		String title = titleService.getDefaultTitle();
		assertEquals("Hello Spring4 !!", title);
	}

	/**
	 * testCase Japan
	 */
	@Test
	public void testGetTitle_Japan() {

		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.JAPAN;

		// mock
		GreetingDaoMockSetter.returnJapaneseGreeting(greetingDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.JAPANESE_GREETING + " " + user.name + " San", title);
	}

	/**
	 * testCase China
	 */
	@Test
	public void testGetTitle_China() {

		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.CHINA;

		// mock
		GreetingDaoMockSetter.returnChineseGreeting(greetingDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.CHINESE_GREETING + " " + user.name + " XianSheng", title);
	}

	/**
	 * testCase France
	 */
	@Test
	public void testGetTitle_France() {

		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.FRANCE;

		// mock
		GreetingDaoMockSetter.returnFrenchGreeting(greetingDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.FRENCH_GREETING + " " + "Monsieur." + user.name, title);
	}

	/**
	 * testCase Other Country
	 */
	@Test
	public void testGetTitle_OtherCountry() {

		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.US;

		// mock
		GreetingDaoMockSetter.returnEnglishGreeting(greetingDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.ENGLISH_GREETING + " " + "Mr." + user.name, title);
	}
}
