package com.mkyong.helloworld.service;

import java.util.Locale;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mkyong.helloworld.TestCaseBase;
import com.mkyong.helloworld.service.dao.TitleDao;
import com.mkyong.helloworld.service.dao.mock.TitleDaoMockSetter;
import com.mkyong.helloworld.service.entity.UserEntity;

public class TitleServiceImplTest extends TestCaseBase {

	@InjectMocks
	private TitleServiceImpl titleService = new TitleServiceImpl();

	@Mock
	private TitleDao titleDao;

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
		TitleDaoMockSetter.returnJapaneseGreeting(titleDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(TitleDaoMockSetter.JAPANESE_GREETING + " " + user.name + " San", title);
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
		TitleDaoMockSetter.returnChineseGreeting(titleDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(TitleDaoMockSetter.CHINESE_GREETING + " " + user.name + " XianSheng", title);
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
		TitleDaoMockSetter.returnFrenchGreeting(titleDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(TitleDaoMockSetter.FRENCH_GREETING + " " + "Monsieur." + user.name, title);
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
		TitleDaoMockSetter.returnEnglishGreeting(titleDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(TitleDaoMockSetter.ENGLISH_GREETING + " " + "Mr." + user.name, title);
	}
}
