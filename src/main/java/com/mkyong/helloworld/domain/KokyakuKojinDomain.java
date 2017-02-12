package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

import lombok.Getter;

/**
 * 個人顧客ドメイン
 * 
 * @author ShowKa
 *
 */
@Getter
public class KokyakuKojinDomain extends KokyakuDomain {

	// private member
	/** 親顧客コード. */
	private KokyakuDomain oyaKokyakuDomain;

	// Constructor
	/**
	 * コンストラクタ.
	 * 
	 * @param code
	 *            顧客コード
	 * @param genteiKubun
	 *            限定区分
	 * @param kokyakuKubun
	 *            顧客区分
	 * @param name
	 *            顧客名
	 * @param address
	 *            住所
	 * @param shukanBushoCode
	 *            主幹部署コード
	 * @param oyaKokyakuCode
	 *            親顧客コード
	 */
	public KokyakuKojinDomain(String code, GenteiKubun genteiKubun, KokyakuKubun kokyakuKubun, String name,
			String address, BushoDomain shukanBushoDomain, KokyakuDomain oyaKokyakuDomain) {
		super(code, genteiKubun, kokyakuKubun, name, address, shukanBushoDomain);
		this.oyaKokyakuDomain = oyaKokyakuDomain;
	}
	// public Method

	// private method
}