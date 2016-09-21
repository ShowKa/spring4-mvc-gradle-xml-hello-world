package com.mkyong.helloworld.service;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mkyong.helloworld.TestCaseBase;
import com.mkyong.helloworld.service.dao.TitleDao;
import com.mkyong.helloworld.service.entity.UserEntity;

@RunWith(MockitoJUnitRunner.class)
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

	@Test
	public void testGetTitle_Japan() {

		// data
		UserEntity user = new UserEntity();
		user.name = "ShowKa";
		user.locale = Locale.JAPAN;

		// mock
		when(titleDao.getGreeting((Locale) anyObject())).thenReturn("Konnichiha");

		// test
		String title = titleService.getTitle(user);
		assertEquals("Konnichiha ShowKa", title);
	}
}
