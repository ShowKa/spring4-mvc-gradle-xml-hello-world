package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.entity.Country;

public interface CountryDao {
	Country getByKey(int id);

	void persist(Country country);
}
