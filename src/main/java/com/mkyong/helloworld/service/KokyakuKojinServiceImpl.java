package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuKojinDao;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.service.i.KokyakuKojinService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;

public class KokyakuKojinServiceImpl extends KokyakuServiceImpl implements KokyakuKojinService {

	@Autowired
	KokyakuKojinDao kokyakuKojinDao;

	@Autowired
	KokyakuTantoBushoService kokyakuTantoBushoService;

	@Override
	public boolean validateKokyakuKojin(KokyakuKojinDomain domain) {
		// 顧客区分チェック
		if (!domain.isKojin()) {
			return false;
		}

		// 親納品先が存在しないならNG
		if(!this.existsKokyaku(domain.getOyaKokyakuDomain().getCode())) {
			return false;
		}

		// この個人顧客の担当部署 ∈ 親納品先の担当部署一覧
		// FIXME 多分、ここでやるべき処理じゃない。
		return kokyakuTantoBushoService.existsTantoBusho(domain.getCode(), null);
	}
	
	@Override
	public boolean registerKokyakuKojin(KokyakuKojinDomain domain) {
		kokyakuKojinDao.register(domain);
		return true;
	}

}
