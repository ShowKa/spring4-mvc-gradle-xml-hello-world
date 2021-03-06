package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mkyong.helloworld.dao.i.KokyakuKojinDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.service.i.KokyakuKojinService;
import com.mkyong.helloworld.system.exception.EmptyException;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.NotExistException;

@Component
@Service
@Transactional
public class KokyakuKojinServiceImpl extends KokyakuServiceImpl implements KokyakuKojinService {

	@Autowired
	private KokyakuKojinDao kokyakuKojinDao;

	/**
	 * 顧客個人整合性検証
	 */
	@Override
	public boolean validate(KokyakuKojinDomain domain) {
		// 顧客区分チェック
		if (!domain.isKojin()) {
			throw new IncorrectKubunException("顧客区分", domain.getKokyakuKubun());
		}

		// 親顧客コード未入力ならNG
		KokyakuDomain oya = domain.getOyaKokyakuDomain();
		if (StringUtils.isEmpty(oya.getCode())) {
			throw new EmptyException("親顧客");
		}

		// 住所未入力ならNG
		if (StringUtils.isEmpty(domain.getAddress())) {
			throw new EmptyException("住所");
		}

		// 親顧客が存在しないならNG
		if (!this.existsKokyaku(oya.getCode())) {
			throw new NotExistException("親顧客として指定した顧客", oya.getCode());
		}

		// 親顧客が個人顧客ならNG
		if (oya.isKojin()) {
			throw new IncorrectKubunException("親納品先", oya.getKokyakuKubun());
		}

		// 基底ドメインの整合性検証
		super.validate(domain);

		return true;
	}

	@Override
	public boolean register(KokyakuKojinDomain domain) {
		// 基底クラス登録（依存関係を考慮し、基底クラスが先）
		super.register(domain);
		kokyakuKojinDao.register(domain);
		return true;
	}
}
