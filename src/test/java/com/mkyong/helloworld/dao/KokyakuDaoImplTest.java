package com.mkyong.helloworld.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.entity.MKokyaku;

public class KokyakuDaoImplTest extends DaoTestCaseBase {
	@Autowired
	private KokyakuDaoImpl kokyakuDao;

	@Test
	public void testGetByPK() {
		MKokyaku entity = kokyakuDao.getByPrimaryKey("UT001");
		Assert.assertEquals(entity.getName(), "UT001顧客");
	}

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
	public void testPersist() {
		// create entity
		MKokyaku e = new MKokyaku();
		e.setCode("aaa");
		e.setShukanBushoCode("UT001");
		e.setAddress("aaa");
		e.setGenteiKubun("1");
		e.setKokyakuKubun("1");
		e.setName("asjfka");

		// save
		kokyakuDao.persist(e);

		// get result
		MKokyaku r = kokyakuDao.getByPrimaryKey("aaa");
		Assert.assertEquals(e.getCode(), r.getCode());
		Assert.assertEquals(e.getName(), r.getName());
	}

	@Test
	public void testUpdate() {
		// create entity
		MKokyaku e = new MKokyaku();
		e.setCode("UT001");
		e.setShukanBushoCode("UT001");
		e.setAddress("changeAddress");
		e.setGenteiKubun("1");
		e.setKokyakuKubun("1");
		e.setName("changeName");
		// 注意！ コミットしないとupdateの楽観的排他制御は有効とならない。
		e.setVersion(1);

		// 更新
		kokyakuDao.update(e);

		// get result
		MKokyaku r = kokyakuDao.getByPrimaryKey("UT001");
		Assert.assertEquals("changeName", r.getName());
	}

	@Test
	public void testDelete() {
		// create entity
		MKokyaku e = new MKokyaku();
		e.setCode("UT001");
		e.setShukanBushoCode("dummy");
		e.setAddress("dummy");
		e.setGenteiKubun("dummy");
		e.setKokyakuKubun("dummy");
		e.setName("dummy");
		e.setVersion(1);

		// 削除
		kokyakuDao.delete(e);

		// get result
		MKokyaku r = kokyakuDao.getByPrimaryKey("UT001");
		Assert.assertNull(r);
	}

	@Test
	public void testDeleteWithPkAndVersion() {
		// 削除
		kokyakuDao.delete("UT001", 1);

		// get result
		MKokyaku r = kokyakuDao.getByPrimaryKey("UT001");
		Assert.assertNull(r);
	}
}
