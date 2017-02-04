package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.entity.MKokyaku;
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
	/** 顧客個人Entity. */
	private MKokyakuKojin kokyakuKojinEntity;

	// Constructor
	/**
	 * コンストラクタ.
	 * 
	 * @param kokyakuEntity
	 *            顧客Entity
	 * @param kokyakuKojinEntity
	 *            顧客個人Entity
	 */
	public KokyakuKojinDomain(MKokyaku kokyakuEntity, MKokyakuKojin kokyakuKojinEntity) {
		super(kokyakuEntity);
		this.kokyakuKojinEntity = kokyakuKojinEntity;
	}

	// public Method

	// private method
}