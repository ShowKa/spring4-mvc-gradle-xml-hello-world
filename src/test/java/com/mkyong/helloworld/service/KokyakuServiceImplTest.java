package com.mkyong.helloworld.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;

import junit.framework.TestCase;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class KokyakuServiceImplTest extends TestCase {

	@Tested
	KokyakuServiceImpl service;

	@Injectable
	private KokyakuDao kokyakuDao;

	@Test
	public void testRegister() {

		// data
		KokyakuDomain domain = new KokyakuDomainBuilder().build();

		// Mock
		new Expectations() {
			{
				kokyakuDao.register(domain);
			}
		};

		// test
		boolean actual = service.register(domain);
		assertEquals(true, actual);

		// Verification
		new Verifications() {
			{
				kokyakuDao.register(domain);
				times = 1;
			}
		};
	}

}
