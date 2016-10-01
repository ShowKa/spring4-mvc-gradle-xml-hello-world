package com.mkyong.helloworld.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.entity.Country;

@Component
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(eq("country", name));
		List<Country> list = criteria.list();
		return list;
	}
}
