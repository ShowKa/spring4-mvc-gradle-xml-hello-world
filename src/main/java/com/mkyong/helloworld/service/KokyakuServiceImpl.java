package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.service.i.BushoService;
import com.mkyong.helloworld.service.i.KokyakuService;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.NotExistException;

@Component
@Service
@Transactional
public class KokyakuServiceImpl implements KokyakuService {

	// service
	/** 部署サービス */
	@Autowired
	private BushoService bushoService;

	// dao
	/** 顧客DAO */
	@Autowired
	private KokyakuDao kokyakuDao;

	/**
	 * 顧客存在チェック
	 */
	@Override
	public boolean existsKokyaku(String kokykuCode) {
		MKokyaku entity = kokyakuDao.getByPrimaryKey(kokykuCode);
		if (entity == null) {
			return false;
		}
		return true;
	}

	/**
	 * 顧客新規登録
	 */
	@Override
	public boolean registerKokyakuHojin(KokyakuDomain domain) {
		kokyakuDao.register(domain);
		return true;
	}

	/**
	 * 法人顧客整合性検証
	 */
	@Override
	public boolean validateKokyakuHojin(KokyakuDomain domain) {

		// 顧客区分=法人 ならOK
		if (!domain.isHojin()) {
			throw new IncorrectKubunException("顧客区分", domain.getKokyakuKubun());
		}

		// 限定区分=限定しないならOK
		if (GenteiKubun.限定しない != domain.getGenteiKubun()) {
			throw new IncorrectKubunException("限定区分", domain.getGenteiKubun());
		}
		return true;
	}

	/**
	 * 顧客整合性検証
	 */
	@Override
	public boolean validateKokyaku(KokyakuDomain domain) {

		// 主幹部署存在しないならエラー
		BushoDomain shukanBusho = domain.getShukanBushoDomain();
		boolean existsShukanBusho = bushoService.existsBusho(shukanBusho.getCode());
		if (!existsShukanBusho) {
			throw new NotExistException("主幹部署", shukanBusho.getCode());
		}

		// 主幹部署が営業所ならOK
		if (BushoKubun.営業所 != shukanBusho.getBushoKubun()) {
			throw new IncorrectKubunException("主幹部署", shukanBusho.getBushoKubun());
		}

		return true;
	}

	/**
	 * 顧客ドメイン取得
	 */
	@Override
	public KokyakuDomain getKokyakuDomain(String kokyakuCode) {
		// entity
		MKokyaku e = kokyakuDao.getByPrimaryKey(kokyakuCode);

		// 主幹部署
		BushoDomain shukanBusho = bushoService.getBushoDomain(e.getShukanBushoCode());

		// build domain
		KokyakuDomainBuilder builder = new KokyakuDomainBuilder();
		KokyakuDomain domain = builder.withAddress(e.getAddress())
				.withCode(e.getCode())
				.withGenteiKubun(GenteiKubun.valueOf(e.getGenteiKubun()))
				.withKokyakuKubun(KokyakuKubun.valueOf(e.getKokyakuKubun()))
				.withName(e.getName())
				.withShukanBushoDomain(shukanBusho)
				.build();
		return domain;
	}
}
