package com.mkyong.helloworld.service;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mkyong.helloworld.service.dao.TitleDao;
import com.mkyong.helloworld.service.dao.mock.TitleDaoMockSetter;
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
	private TitleDao titleDao;

	@Test
	public void testDefault() {
		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.JAPAN;

		// mock
		TitleDaoMockSetter.expectJapaneseGreeting(titleDao);

		// test
		String title = titleService.getTitle(user);
		assertEquals(TitleDaoMockSetter.JAPANESE_GREETING + " " + user.name + " San", title);

		// Verification
		new Verifications() {
			{
				titleDao.getGreeting(Locale.JAPAN);
				times = 1;
				titleDao.getGreeting(Locale.CHINA);
				times = 0;
			}
		};

	}
}
