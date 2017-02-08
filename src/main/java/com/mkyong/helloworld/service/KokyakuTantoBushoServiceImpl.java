package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.entity.MKokyakuBushoPK;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;

public class KokyakuTantoBushoServiceImpl implements KokyakuTantoBushoService {

	@Autowired
	KokyakuBushoDao kokyakuBushoDao;

	@Autowired
	private KokyakuDao kokyakuDao;

	@Override
	public boolean existsTantoBusho(String kokyakuCode, String bushoCode) {
		MKokyakuBushoPK id = new MKokyakuBushoPK(kokyakuCode, bushoCode);
		MKokyakuBusho e = kokyakuBushoDao.getByPrimaryKey(id);
		if (e == null) {
			return false;
		}
		return true;
	}

	@Override
	public void update(KokyakuTantoBushoDomain domain) {
		kokyakuBushoDao.update(domain.getMKokyakuBushoEntity());
	}

	@Override
	public void persist(KokyakuTantoBushoDomain domain) {
		kokyakuBushoDao.persist(domain.getMKokyakuBushoEntity());
	}

}
