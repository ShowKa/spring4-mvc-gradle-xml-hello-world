package com.mkyong.helloworld.service;

import java.util.Locale;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mkyong.helloworld.TestCaseBase;
import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.dao.i.GreetingDao;
import com.mkyong.helloworld.entity.User;
import com.mkyong.helloworld.service.dao.mock.CountryDaoMockSetter;
import com.mkyong.helloworld.service.dao.mock.GreetingDaoMockSetter;

public class TitleServiceImplTestMockito extends TestCaseBase {

	@InjectMocks
	private TitleServiceImpl titleService = new TitleServiceImpl();

	@Mock
	private GreetingDao greetingDao;

	@Mock
	private CountryDao CountryDao;

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
		User user = new User();
		user.name = "ShowKa";
		user.locale = Locale.JAPAN;

		// mock
		GreetingDaoMockSetter.returnJapaneseGreeting(greetingDao);
		CountryDaoMockSetter.returnJapan(CountryDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.JAPANESE_GREETING + " " + user.name + " San" + " from "
				+ CountryDaoMockSetter.JAPAN.country, title);
	}

	/**
	 * testCase China
	 */
	@Test
	public void testGetTitle_China() {

		// data
		User user = new User();
		user.name = "ShowKa";
		user.locale = Locale.CHINA;

		// mock
		GreetingDaoMockSetter.returnChineseGreeting(greetingDao);
		CountryDaoMockSetter.returnChina(CountryDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.CHINESE_GREETING + " " + user.name + " XianSheng" + " from "
				+ CountryDaoMockSetter.CHINA.country, title);
	}

	/**
	 * testCase France
	 */
	@Test
	public void testGetTitle_France() {

		// data
		User user = new User();
		user.name = "ShowKa";
		user.locale = Locale.FRANCE;

		// mock
		GreetingDaoMockSetter.returnFrenchGreeting(greetingDao);
		CountryDaoMockSetter.returnFrance(CountryDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.FRENCH_GREETING + " " + "Monsieur." + user.name + " from "
				+ CountryDaoMockSetter.FRANCE.country, title);
	}

	/**
	 * testCase Other Country
	 */
	@Test
	public void testGetTitle_OtherCountry() {

		// data
		User user = new User();
		user.name = "ShowKa";
		user.locale = Locale.US;

		// mock
		GreetingDaoMockSetter.returnEnglishGreeting(greetingDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.ENGLISH_GREETING + " " + "Mr." + user.name + " from " + "Somewhere", title);
	}
}
