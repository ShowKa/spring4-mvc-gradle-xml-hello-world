package com.mkyong.helloworld.service.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.service.entity.Country;

@Component
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {
	public Country getByKey(int id) {
		return super.getByKey(id);
	}

	public void persist(Country country) {
		super.persist(country);
	}

}
