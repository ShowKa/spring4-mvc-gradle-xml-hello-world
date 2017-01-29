package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.entity.MKokyakuBusho;
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
	private MKokyaku kokyaku;
	/** 顧客部署Entity. */
	private MKokyakuBusho kokyakuBusho;

	// DAO

	// Constructor

	// public method
	/**
	 * 個人限定判定
	 * 
	 * @retrun 個人限定顧客ならtrue
	 */
	public boolean isKojinGentei() {
		if (isKojin() && GenteiKubun.限定.eq(kokyaku.getGenteiKubun())) {
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
		if (KokyakuKubun.個人.eq(kokyaku.getKokyakuKubun())) {
			return true;
		}
		return false;
	}
}
