package com.mkyong.helloworld.service;

import org.junit.Test;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.builder.BushoDomainBuilder;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.system.exception.ApplicationException;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

public class KokyakuServiceImplTest extends ServiceTestCaseBase {

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
		boolean actual = service.registerKokyakuHojin(domain);
		assertEquals(true, actual);

		// Verification
		new Verifications() {
			{
				kokyakuDao.register(domain);
				times = 1;
			}
		};
	}

	@Test
	public void testValidateHojin_gentei() {
		expectedEx.expect(ApplicationException.class);
		expectedEx.expectMessage("AP0001");
		KokyakuDomain domain = new KokyakuDomainBuilder().withGenteiKubun(GenteiKubun.限定).build();
		service.validateKokyakuHojin(domain);
		fail();
	}

	@Test
	public void testValidateHojin_shukanBusho() {
		expectedEx.expect(ApplicationException.class);
		expectedEx.expectMessage("AP0001");
		BushoDomain shukanBushoDomain = new BushoDomainBuilder().withBushoKubun(BushoKubun.本部).build();
		KokyakuDomain domain = new KokyakuDomainBuilder().withGenteiKubun(GenteiKubun.限定しない)
				.withShukanBushoDomain(shukanBushoDomain)
				.build();
		service.validateKokyakuHojin(domain);
		fail();
	}

	@Test
	public void testValidateHojin() {
		BushoDomain shukanBushoDomain = new BushoDomainBuilder().withBushoKubun(BushoKubun.営業所).build();
		KokyakuDomain domain = new KokyakuDomainBuilder().withKokyakuKubun(KokyakuKubun.法人)
				.withGenteiKubun(GenteiKubun.限定しない)
				.withShukanBushoDomain(shukanBushoDomain)
				.build();
		boolean actual = service.validateKokyakuHojin(domain);
		assertEquals(true, actual);
	}
}
