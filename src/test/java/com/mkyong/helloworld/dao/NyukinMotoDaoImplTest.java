package com.mkyong.helloworld.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.NyukinMotoDao;
import com.mkyong.helloworld.entity.MNyukinKakeInfo;
import com.mkyong.helloworld.entity.MNyukinMoto;

public class NyukinMotoDaoImplTest extends DaoTestCaseBase {

	@Autowired
	private NyukinMotoDao nyukinMotoDao;

	@Test
	public void testFetch() {
		MNyukinMoto result = nyukinMotoDao.getByPrimaryKey(1);
		MNyukinKakeInfo kake = result.getMNyukinKakeInfo();

		Assert.assertEquals(Integer.valueOf(1), result.getId());
		Assert.assertEquals(20, kake.getNyukinDate());
	}
}
