package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.service.i.KokyakuKojinService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;

public class KokyakuKojinServiceImpl extends KokyakuServiceImpl implements KokyakuKojinService {

	@Autowired
	KokyakuDao kokyakuDao;

	@Autowired
	KokyakuTantoBushoService kokyakuTantoBushoService;

	@Override
	public boolean validateKojin(KokyakuKojinDomain kojinKokyakuDomain, String tantoBushoCode) {
		// 個人チェック
		if (!kojinKokyakuDomain.isKojin()) {
			return false;
		}

		// 親顧客設定チェック
		if (kojinKokyakuDomain.getOyaKokyakuDomain() == null) {
			return false;
		}

		// この個人顧客の担当部署 ∈ 親納品先の担当部署一覧
		return kokyakuTantoBushoService.existsTantoBusho(kojinKokyakuDomain.getCode(), tantoBushoCode);
	}
}
