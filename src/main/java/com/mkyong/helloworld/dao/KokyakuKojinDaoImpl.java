package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.i.KokyakuKojinDao;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.entity.MKokyakuKojin;

public class KokyakuKojinDaoImpl extends AbstractDao<String, MKokyakuKojin> implements KokyakuKojinDao {

	@Autowired
	private KokyakuDao kokyakuDao;

	@Override
	public KokyakuKojinDomain getKokyakuKojinDomain(String kojinKokyakuCode) {
		// 顧客Entity取得
		MKokyaku mKokyaku = kokyakuDao.getByPrimaryKey(kojinKokyakuCode);
		// 個人顧客Entity取得
		MKokyakuKojin mKokyakuKojin = getByPrimaryKey(kojinKokyakuCode);
		// 生成
		return new KokyakuKojinDomain(mKokyaku, mKokyakuKojin);
	}

}
