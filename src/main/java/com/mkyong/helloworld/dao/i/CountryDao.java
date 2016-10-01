package com.mkyong.helloworld.dao.i;

import java.util.List;

import com.mkyong.helloworld.entity.Country;

public interface CountryDao {
	public Country getByKey(Integer key);

	public void persist(Country country);

	public void delete(Country country);

	public List<Country> getByName(String name);
}
