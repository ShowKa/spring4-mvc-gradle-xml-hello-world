package com.mkyong.helloworld.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.builder.BushoDomainBuilder;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

public class KokyakuDaoImplTest extends DaoTestCaseBase {
	@Autowired
	private KokyakuDaoImpl kokyakuDao;

	@Test
	public void testGetByName() {
		List<MKokyaku> entities = kokyakuDao.searchByName("T001顧");
		Assert.assertTrue(!entities.isEmpty());
		for (MKokyaku e : entities) {
			Assert.assertTrue(e.getName().indexOf("T001顧") != -1);
		}
	}

	@Test
	public void testSearchByCode() {
		KokyakuSearchParameter param = new KokyakuSearchParameter("UT001", null);
		List<MKokyaku> entities = kokyakuDao.search(param);
		Assert.assertTrue(!entities.isEmpty());
		for (MKokyaku e : entities) {
			Assert.assertEquals(e.getCode(), "UT001");
		}
	}

	@Test
	public void testSearchByName() {
		KokyakuSearchParameter param = new KokyakuSearchParameter(null, "T001顧");
		List<MKokyaku> entities = kokyakuDao.search(param);
		Assert.assertTrue(!entities.isEmpty());
		for (MKokyaku e : entities) {
			Assert.assertTrue(e.getName().indexOf("T001顧") != -1);
		}
	}

	@Test
	public void testSearchByCodeAndName() {
		KokyakuSearchParameter param = new KokyakuSearchParameter("UT001", "T001顧");
		List<MKokyaku> entities = kokyakuDao.search(param);
		Assert.assertTrue(!entities.isEmpty());
		for (MKokyaku e : entities) {
			Assert.assertEquals(e.getCode(), "UT001");
		}
	}

	@Test
	public void testRegister() {
		// register
		// [注意] コミットしない限り、一意制約違反は起きない。
		KokyakuDomain d = new KokyakuDomainBuilder().withAddress("住所テスト")
				.withCode("XXXXX")
				.withGenteiKubun(GenteiKubun.限定しない)
				.withKokyakuKubun(KokyakuKubun.法人)
				.withName("名前テスト")
				.withShukanBushoDomain(new BushoDomainBuilder().withCode("UT01").build())
				.build();
		kokyakuDao.register(d);

		// get
		MKokyaku e = kokyakuDao.getByPrimaryKey("XXXXX");

		// assert
		Assert.assertEquals(e.getAddress(), d.getAddress());
		Assert.assertEquals(e.getCode(), d.getCode());
		Assert.assertEquals(e.getGenteiKubun(), d.getGenteiKubun().getCode());
		Assert.assertEquals(e.getKokyakuKubun(), d.getKokyakuKubun().getCode());
		Assert.assertEquals(e.getName(), d.getName());
		Assert.assertEquals(e.getShukanBushoCode(), d.getShukanBushoDomain().getCode());
	}
}
