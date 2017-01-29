package com.mkyong.helloworld.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.entity.MKokyakuBushoId;
import com.mkyong.helloworld.entity.MKokyakuKojin;

import lombok.Getter;

/**
 * 個人顧客ドメイン
 * 
 * @author ShowKa
 *
 */
@Getter
public class KokyakuKojinDomain extends KokyakuDomain {
	// Entity
	/** 親顧客Entity. */
	private MKokyaku oyaKokyaku;
	/** 顧客個人Entity. */
	private MKokyakuKojin kokyakuKojin;

	// DAO
	/** 顧客部署DAO. */
	@Autowired
	private KokyakuBushoDao kokyakuBushoDao;

	// Constructor
	public KokyakuKojinDomain(MKokyaku kokyaku, MKokyakuBusho kokyakuBusho, MKokyaku oyaKokyaku,
			MKokyakuKojin kokyakuKojin) {
		super(kokyaku, kokyakuBusho);
		this.oyaKokyaku = oyaKokyaku;
		this.kokyakuKojin = kokyakuKojin;
	}

	// public Method
	/**
	 * 個人整合性チェック.
	 * 
	 * <pre>
	 * 以下の条件を満たす。
	 * 区分=個人
	 * 親顧客が設定されている
	 * 親として指定された顧客の顧客部署 = この個人顧客の担当部署
	 * </pre>
	 * 
	 * @return true
	 */
	public boolean validateKojin() {
		if (!isKojin()) {
			return false;
		}
		if (oyaKokyaku == null) {
			return false;
		}
		MKokyakuBushoId pk = new MKokyakuBushoId(oyaKokyaku.getCode(), getKokyakuBusho().getMBusho().getCode());
		KokyakuDomain oya = kokyakuBushoDao.getKokyakuDomain(pk);
		if (oya == null) {
			return false;
		}
		return true;
	}

	/**
	 * 親顧客の顧客ドメインを取得.
	 * 
	 * @return 親顧客ドメイン
	 */
	public KokyakuDomain getOyaKokyakuDomain() {
		MKokyakuBushoId pk = new MKokyakuBushoId(oyaKokyaku.getCode(), getKokyakuBusho().getMBusho().getCode());
		return kokyakuBushoDao.getKokyakuDomain(pk);
	}

	// private method
}