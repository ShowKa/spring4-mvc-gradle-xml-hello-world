package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.ShohizeiKubun;

import lombok.Getter;

@Getter
public class KokyakuKojinTantoBushoDomain extends KokyakuTantoBushoDomain {

	/** 顧客個人ドメイン */
	private KokyakuKojinDomain kokyakuKojinDomain;

	/**
	 * コンストラクタ
	 * 
	 * @param kokyakuKojinDomain
	 * @param bushoDomain
	 * @param shohizeiKubun
	 * @param sekininshaName
	 * @param kokyakuTantoBushoHanbaiDomain
	 * @param kokyakuTantoBushoRentalDomain
	 * @param nyukinMotoDomain
	 * @param seikyuSakiDomain
	 * @param version
	 */
	public KokyakuKojinTantoBushoDomain(KokyakuKojinDomain kokyakuKojinDomain, BushoDomain bushoDomain,
			ShohizeiKubun shohizeiKubun, String sekininshaName,
			KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain,
			KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain, NyukinMotoDomain nyukinMotoDomain,
			SeikyuSakiDomain seikyuSakiDomain, int version) {

		super(kokyakuKojinDomain, bushoDomain, shohizeiKubun, sekininshaName, kokyakuTantoBushoHanbaiDomain,
				kokyakuTantoBushoRentalDomain, nyukinMotoDomain, seikyuSakiDomain, version);
		this.kokyakuKojinDomain = kokyakuKojinDomain;
	}

}
