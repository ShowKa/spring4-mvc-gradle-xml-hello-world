package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.i.KokyakuKojinDao;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.entity.MKokyakuKojin;

@Component
public class KokyakuKojinDaoImpl extends AbstractDao<String, MKokyakuKojin> implements KokyakuKojinDao {

	@Autowired
	private KokyakuDao kokyakuDao;

	@Override
	public void register(KokyakuKojinDomain domain) {
		// 顧客登録
		kokyakuDao.register(domain);

		// 顧客個人登録
		MKokyakuKojin e = new MKokyakuKojin();
		e.setKokyakuCode(domain.getCode());
		e.setOyaKokyakuCode(domain.getOyaKokyakuDomain().getCode());
		persist(e);
	}

}
