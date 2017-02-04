package com.mkyong.helloworld.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.entity.MKokyaku;

@Component
public class KokyakuDaoImpl extends AbstractDao<String, MKokyaku> implements KokyakuDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<MKokyaku> search(KokyakuSearchParameter param) {

		Criteria criteria = createEntityCriteria();

		String code = param.getCode();
		if (!StringUtils.isEmpty(code)) {
			criteria.add(Restrictions.eq("code", code));
		}

		String name = param.getName();
		if (!StringUtils.isEmpty(name)) {
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("code"));
		return criteria.list();
	}

	@Override
	public List<MKokyaku> searchByName(String name) {

		// criteria
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		criteria.addOrder(Order.asc("code"));

		// search
		final List<MKokyaku> list = new ArrayList<>();

		// CAST
		for (final Object o : criteria.list()) {
			list.add((MKokyaku) o);
		}
		return list;
	}

	@Override
	public KokyakuDomain getKokyakuDomain(String kokyakuCode) {
		MKokyaku mKokyaku = getByPrimaryKey(kokyakuCode);
		return new KokyakuDomain(mKokyaku);
	}
}
