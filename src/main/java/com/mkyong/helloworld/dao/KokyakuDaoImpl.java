package com.mkyong.helloworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.entity.MKokyaku;

@Component
public class KokyakuDaoImpl extends AbstractDao<String, MKokyaku> implements KokyakuDao {

	/**
	 * 顧客検索処理
	 */
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
			criteria.add(Restrictions.like("name", "%" + name + "%"));
		}

		criteria.addOrder(Order.asc("code"));
		return criteria.list();
	}

	/**
	 * 顧客検索処理
	 * 
	 * <pre>
	 * 顧客名で検索
	 * </pre>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<MKokyaku> searchByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		return criteria.list();
	}

}
