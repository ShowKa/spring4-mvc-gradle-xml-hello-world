package com.mkyong.helloworld.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.entity.MKokyaku;

public class KokyakuDaoImplTest extends DaoTestCaseBase {
	@Autowired
	private KokyakuDaoImpl kokyakuDao;

	@Test
	public void testGetById() {
		MKokyaku entity = kokyakuDao.getByPrimaryKey("001");
		Assert.assertEquals(entity.getName(), "株式会社ShowKa");
	}
}
