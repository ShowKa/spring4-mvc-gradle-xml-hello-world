package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.ShohizeiKubun;

import lombok.Getter;

@Getter
public class KokyakuKojinTantoBushoDomain extends KokyakuTantoBushoDomain {

	/** 顧客個人ドメイン */
	private KokyakuKojinDomain kokyakuKojinDomain;

	public KokyakuKojinTantoBushoDomain(KokyakuKojinDomain kokyakuKojinDomain, BushoDomain budhoDomain,
			ShohizeiKubun shohizeiKubun, String sekininshaName, NyukinMotoDomain nyukinMotoDomain,
			SeikyuSakiDomain seikyuSakiDomain, int version) {
		super(kokyakuKojinDomain, budhoDomain, shohizeiKubun, sekininshaName, nyukinMotoDomain, seikyuSakiDomain,
				version);
		this.kokyakuKojinDomain = kokyakuKojinDomain;
	}

}
