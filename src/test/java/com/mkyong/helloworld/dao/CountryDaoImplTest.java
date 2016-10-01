package com.mkyong.helloworld.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.entity.Country;

public class CountryDaoImplTest extends DaoTestCaseBase {

	@Autowired
	private CountryDaoImpl countryDao;

	@Test
	public void testGetById() {
		assertEquals(countryDao.getByKey(50).country, "Japan");
	}

	@Test
	public void testGetByName() {
		// data
		String countryName = "Japan";

		// get
		List<Country> result = countryDao.getByName(countryName);

		// assert
		assertEquals(result.get(0).country, "Japan");
	}

	@Test
	public void testPersist() {

		// test data
		Country testDataCountry = new Country();
		testDataCountry.country_id = 999;
		testDataCountry.country = "testCountry";
		testDataCountry.lastUpdate = new Timestamp(System.currentTimeMillis());

		// insert
		countryDao.persist(testDataCountry);

		// get inserted
		Country result = countryDao.getByKey(testDataCountry.country_id);

		// assert
		assertEquals(result.country, testDataCountry.country);
	}
}
