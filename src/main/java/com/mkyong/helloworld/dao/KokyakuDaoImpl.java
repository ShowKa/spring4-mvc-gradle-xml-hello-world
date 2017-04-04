package com.mkyong.helloworld.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mkyong.helloworld.dao.i.BushoDao;
import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

@Component
public class KokyakuDaoImpl extends AbstractDao<String, MKokyaku> implements KokyakuDao {

	// DAO
	@Autowired
	private BushoDao bushoDao;

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
		final List<MKokyaku> list = new ArrayList<MKokyaku>();

		// CAST
		for (final Object o : criteria.list()) {
			list.add((MKokyaku) o);
		}
		return list;
	}

	/**
	 * 顧客ドメイン取得
	 */
	@Override
	public KokyakuDomain getDomain(String kokyakuCode) {

		// get entity
		MKokyaku e = getByPrimaryKey(kokyakuCode);

		// get another domains
		BushoDomain shukanBushoDomain = bushoDao.getBushoDomain(e.getShukanBushoCode());

		// build domain
		KokyakuDomainBuilder builder = new KokyakuDomainBuilder();
		builder.withAddress(e.getAddress());
		builder.withCode(kokyakuCode);
		builder.withGenteiKubun(GenteiKubun.valueOf(e.getGenteiKubun()));
		builder.withKokyakuKubun(KokyakuKubun.valueOf(e.getKokyakuKubun()));
		builder.withName(e.getName());
		builder.withShukanBushoDomain(shukanBushoDomain);

		return builder.build();
	}

	@Override
	public void register(KokyakuDomain domain) {
		MKokyaku entity = new MKokyaku();
		entity.setAddress(domain.getAddress());
		entity.setCode(domain.getCode());
		entity.setGenteiKubun(domain.getGenteiKubun().getCode());
		entity.setKokyakuKubun(domain.getKokyakuKubun().getCode());
		entity.setName(domain.getName());
		entity.setShukanBushoCode(domain.getShukanBushoDomain().getCode());
		persist(entity);
	}

}
