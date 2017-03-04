package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.KokyakuKojinDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.service.i.KokyakuKojinService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.NotExistException;

@Component
@Service
@Transactional
public class KokyakuKojinServiceImpl extends KokyakuServiceImpl implements KokyakuKojinService {

	@Autowired
	KokyakuKojinDao kokyakuKojinDao;

	@Autowired
	KokyakuTantoBushoService kokyakuTantoBushoService;

	/**
	 * 顧客個人整合性検証
	 */
	@Override
	public boolean validateKokyakuKojin(KokyakuKojinDomain domain) {
		// 顧客区分チェック
		if (!domain.isKojin()) {
			throw new IncorrectKubunException("顧客区分", domain.getKokyakuKubun());
		}

		// 親顧客が存在しないならNG
		KokyakuDomain oya = domain.getOyaKokyakuDomain();
		if (!this.existsKokyaku(oya.getCode())) {
			throw new NotExistException("親顧客として指定した顧客", oya.getCode());
		}

		// 親顧客が個人顧客ならNG
		if (oya.isKojin()) {
			throw new IncorrectKubunException("親納品先", oya.getKokyakuKubun());
		}

		return true;
	}

	@Override
	public boolean registerKokyakuKojin(KokyakuKojinDomain domain) {
		kokyakuKojinDao.register(domain);
		return true;
	}

}
