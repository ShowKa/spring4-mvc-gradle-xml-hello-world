package com.mkyong.helloworld.service.dao;

import com.mkyong.helloworld.service.entity.Country;

public interface CountryDao {
	Country getByKey(int id);

	void persist(Country country);
}
