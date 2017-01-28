package com.mkyong.helloworld.service;

import static com.mkyong.helloworld.entity.CountryCatalog.JAPAN;
import static com.mkyong.helloworld.entity.GreetingCatalog.JAPANESE_GREETING;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.dao.i.GreetingDao;
import com.mkyong.helloworld.dao.mock.CountryDaoMockSetter;
import com.mkyong.helloworld.dao.mock.GreetingDaoMockSetter;
import com.mkyong.helloworld.entity.User;

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
		assertEquals(JAPANESE_GREETING + " " + user.name + " San" + " from " + JAPAN.country, title);

		// Verification
		new Verifications() {
			{
				greetingDao.getGreeting(Locale.JAPAN);
				times = 1;
				countryDao.getByPrimaryKey(JAPAN.country_id);
				times = 1;
			}
		};

	}
}
