package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 顧客ドメイン
 * 
 * @author ShowKa
 *
 */
@AllArgsConstructor
@Getter
public class KokyakuDomain {
	// Entities
	/** 顧客Entity. */
	private MKokyaku kokyakuEntity;

	// public method
	/**
	 * 個人限定判定
	 * 
	 * @retrun 個人限定顧客ならtrue
	 */
	public boolean isKojinGentei() {
		if (isKojin() && GenteiKubun.限定.eq(kokyakuEntity.getGenteiKubun())) {
			return true;
		}
		return false;
	}

	/**
	 * 個人判定
	 * 
	 * @return 個人ならtrue
	 */
	public boolean isKojin() {
		if (KokyakuKubun.個人.eq(kokyakuEntity.getKokyakuKubun())) {
			return true;
		}
		return false;
	}
}
