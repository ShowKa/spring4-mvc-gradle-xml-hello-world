package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.service.i.KokyakuService;

@Service
public class KokyakuServiceImpl implements KokyakuService {

	/** 顧客DAO */
	@Autowired
	private KokyakuDao kokyakuDao;

	@Override
	public boolean register(KokyakuDomain domain) {
		kokyakuDao.register(domain);
		return true;
	}

}
