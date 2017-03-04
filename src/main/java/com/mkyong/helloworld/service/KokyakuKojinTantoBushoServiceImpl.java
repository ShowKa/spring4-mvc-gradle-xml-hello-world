package com.mkyong.helloworld.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;
import com.mkyong.helloworld.service.i.KokyakuKojinTantoBushoService;
import com.mkyong.helloworld.system.exception.ValidateException;

@Component
@Service
@Transactional
public class KokyakuKojinTantoBushoServiceImpl extends KokyakuTantoBushoServiceImpl
		implements KokyakuKojinTantoBushoService {

	/**
	 * 顧客個人整合性検証
	 */
	@Override
	public boolean validateKokyakuKojinTantoBusho(KokyakuKojinTantoBushoDomain domain) {
		// この個人顧客の担当部署 ∈ 親納品先の担当部署一覧
		KokyakuKojinDomain kojin = domain.getKokyakuKojinDomain();
		KokyakuDomain oya = kojin.getOyaKokyakuDomain();
		BushoDomain tantoBusho = domain.getBudhoDomain();
		boolean existsTantoBusho = existsTantoBusho(oya.getCode(), tantoBusho.getCode());
		if (!existsTantoBusho) {
			throw new ValidateException("個人顧客の担当部署は、親顧客の担当部署として登録されている必要があります。");
		}

		return true;
	}

}
