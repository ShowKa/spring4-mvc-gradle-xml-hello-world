package com.mkyong.helloworld.service.dao.mock;

import static org.mockito.Mockito.when;

import org.mockito.stubbing.OngoingStubbing;

import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.entity.Country;

import mockit.Expectations;

public class CountryDaoMockSetter {
	public static Country JAPAN = new Country();
	static {
		JAPAN.country_id = 50;
		JAPAN.country = "Japan";
	}

	public static Country CHINA = new Country();
	static {
		CHINA.country_id = 23;
		CHINA.country = "China";
	}

	public static Country FRANCE = new Country();
	static {
		FRANCE.country_id = 34;
		FRANCE.country = "France";
	}

	// Mockito
	public static OngoingStubbing<Country> returnJapan(CountryDao dao) {
		return when(dao.getByKey(JAPAN.country_id)).thenReturn(JAPAN);
	}

	public static OngoingStubbing<Country> returnChina(CountryDao dao) {
		return when(dao.getByKey(CHINA.country_id)).thenReturn(CHINA);
	}

	public static OngoingStubbing<Country> returnFrance(CountryDao dao) {
		return when(dao.getByKey(FRANCE.country_id)).thenReturn(FRANCE);
	}

	// JMockit
	public static Expectations expectJapan(CountryDao dao) {
		return new Expectations() {
			{
				dao.getByKey(JAPAN.country_id);
				result = JAPAN;
			}
		};
	}
}
