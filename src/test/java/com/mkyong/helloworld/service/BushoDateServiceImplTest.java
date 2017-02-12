package com.mkyong.helloworld.service;

import org.junit.Assert;
import org.junit.Test;

import com.mkyong.helloworld.dao.i.KyujitsuDao;
import com.mkyong.helloworld.domain.value.DateWithoutTime;
import com.mkyong.helloworld.entity.MKyujitsu;
import com.mkyong.helloworld.entity.MKyujitsuPK;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

public class BushoDateServiceImplTest extends ServiceTestCaseBase {

	@Tested
	BushoDateServiceImpl service;

	@Injectable
	private KyujitsuDao kyujitsuDao;

	@Test
	public void testisEigyoDate() {
		// data
		String bushoCode = "UT01";
		DateWithoutTime kyujitsu = new DateWithoutTime(2017, 1, 1);

		// Mock
		new Expectations() {
			{
				kyujitsuDao.getByPrimaryKey((MKyujitsuPK) any);
				result = new MKyujitsu();
			}
		};

		// test
		boolean actual = service.isEigyoDate(bushoCode, kyujitsu);
		Assert.assertFalse(actual);

		// Verification
		new Verifications() {
			{
				kyujitsuDao.getByPrimaryKey((MKyujitsuPK) any);
				times = 1;
			}
		};
	}

	@Test
	public void testisEigyoDate_whenKyujitsu() {
		// data
		String bushoCode = "UT01";
		DateWithoutTime kyujitsu = new DateWithoutTime(2017, 1, 1);

		// Mock
		new Expectations() {
			{
				kyujitsuDao.getByPrimaryKey((MKyujitsuPK) any);
				result = null;
			}
		};

		// test
		boolean actual = service.isEigyoDate(bushoCode, kyujitsu);
		Assert.assertTrue(actual);

		// Verification
		new Verifications() {
			{
				kyujitsuDao.getByPrimaryKey((MKyujitsuPK) any);
				times = 1;
			}
		};
	}
}
