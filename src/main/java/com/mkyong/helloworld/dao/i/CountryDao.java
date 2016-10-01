package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.entity.Country;

public interface CountryDao {
	public Country getByKey(Integer key);

	public void persist(Country country);

	public void delete(Country country);
}
