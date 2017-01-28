package com.mkyong.helloworld.dao.mock;

import static com.mkyong.helloworld.entity.CountryCatalog.CHINA;
import static com.mkyong.helloworld.entity.CountryCatalog.FRANCE;
import static com.mkyong.helloworld.entity.CountryCatalog.JAPAN;
import static org.mockito.Mockito.when;

import org.mockito.stubbing.OngoingStubbing;

import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.entity.Country;

import mockit.Expectations;

public class CountryDaoMockSetter {

	// Mockito
	public static OngoingStubbing<Country> returnJapan(CountryDao dao) {
		return when(dao.getByPrimaryKey(JAPAN.country_id)).thenReturn(JAPAN);
	}

	public static OngoingStubbing<Country> returnChina(CountryDao dao) {
		return when(dao.getByPrimaryKey(CHINA.country_id)).thenReturn(CHINA);
	}

	public static OngoingStubbing<Country> returnFrance(CountryDao dao) {
		return when(dao.getByPrimaryKey(FRANCE.country_id)).thenReturn(FRANCE);
	}

	// JMockit
	public static Expectations expectJapan(CountryDao dao) {
		return new Expectations() {
			{
				dao.getByPrimaryKey(JAPAN.country_id);
				result = JAPAN;
			}
		};
	}
}
