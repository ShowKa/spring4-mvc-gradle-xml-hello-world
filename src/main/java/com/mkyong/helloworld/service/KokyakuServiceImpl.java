package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.service.i.KokyakuService;
import com.mkyong.helloworld.system.exception.ApplicationException;

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

	@Override
	public boolean validateHojinKokyaku(KokyakuDomain domain) {

		// 限定区分=限定しないならOK
		if (GenteiKubun.限定しない != domain.getGenteiKubun()) {
			throw new ApplicationException("AP0001");
		}

		// 主幹部署が営業所ならOK
		if (BushoKubun.営業所 != domain.getShukanBushoDomain().getBushoKubun()) {
			throw new ApplicationException("AP0002");
		}

		return true;
	}

}
