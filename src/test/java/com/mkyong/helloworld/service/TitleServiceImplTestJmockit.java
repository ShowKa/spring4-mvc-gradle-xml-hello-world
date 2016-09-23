package com.mkyong.helloworld.service;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mkyong.helloworld.service.dao.GreetingDao;
import com.mkyong.helloworld.service.dao.mock.GreetingDaoMockSetter;
import com.mkyong.helloworld.service.entity.UserEntity;

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

	@Test
	public void testDefault() {
		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.JAPAN;

		// mock
		GreetingDaoMockSetter.expectJapaneseGreeting(greetingDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(GreetingDaoMockSetter.JAPANESE_GREETING + " " + user.name + " San", title);

		// Verification
		new Verifications() {
			{
				greetingDao.getGreeting(Locale.JAPAN);
				times = 1;
				greetingDao.getGreeting(Locale.CHINA);
				times = 0;
			}
		};

	}
}
