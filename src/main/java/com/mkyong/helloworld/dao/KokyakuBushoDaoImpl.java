package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.i.KokyakuKojinDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.entity.MKokyakuBushoId;
import com.mkyong.helloworld.entity.MKokyakuKojin;

public class KokyakuBushoDaoImpl extends AbstractDao<MKokyakuBushoId, MKokyakuBusho> implements KokyakuBushoDao {

	// DAO
	/** 顧客DAO */
	@Autowired
	KokyakuDao kokyakuDao;
	/** 顧客個人ADO */
	@Autowired
	KokyakuKojinDao kokyakuKojinDao;

	// public method
	@Override
	public KokyakuDomain getKokyakuDomain(MKokyakuBushoId pk) {
		MKokyakuBusho kokyakuBusho = getByPrimaryKey(pk);
		if (kokyakuBusho == null) {
			return null;
		}
		MKokyaku kokyaku = kokyakuDao.getByPrimaryKey(kokyakuBusho.getId().getKokyakuCode());
		return new KokyakuDomain(kokyaku, kokyakuBusho);
	}

	@Override
	public KokyakuKojinDomain getKokyakuKojinDomain(MKokyakuBushoId pk) {
		// 顧客ドメイン取得
		KokyakuDomain _kokyaku = getKokyakuDomain(pk);
		// 個人顧客Entity取得
		MKokyakuKojin kk = kokyakuKojinDao.getByPrimaryKey(_kokyaku.getKokyaku().getCode());
		// 親顧客Entity 取得
		MKokyaku oya = kokyakuDao.getByPrimaryKey(kk.getMKokyaku().getCode());
		// 顧客個人ドメイン生成
		return new KokyakuKojinDomain(_kokyaku.getKokyaku(), _kokyaku.getKokyakuBusho(), oya, kk);
	}
}
