package com.mkyong.helloworld.service;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.dao.i.GreetingDao;
import com.mkyong.helloworld.entity.User;
import com.mkyong.helloworld.service.dao.mock.CountryDaoMockSetter;
import com.mkyong.helloworld.service.dao.mock.GreetingDaoMockSetter;

import junit.framework.TestCase;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class TitleServiceImplTestJmockit extends TestCase {

	@Tested
	TitleServiceImpl titleService;

	@Injectable
	private GreetingDao greetingDao;

	@Injectable
	private CountryDao countryDao;

	@Test
	public void testJapan() {
		// data
		User user = new User();
		user.name = "ShowKa";
		user.locale = Locale.JAPAN;

		// mock
		GreetingDaoMockSetter.expectJapaneseGreeting(greetingDao);
		CountryDaoMockSetter.expectJapan(countryDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.JAPANESE_GREETING + " " + user.name + " San" + " from "
				+ CountryDaoMockSetter.JAPAN.country, title);

		// Verification
		new Verifications() {
			{
				greetingDao.getGreeting(Locale.JAPAN);
				times = 1;
				countryDao.getByKey(CountryDaoMockSetter.JAPAN.country_id);
				times = 1;
			}
		};

	}
}
