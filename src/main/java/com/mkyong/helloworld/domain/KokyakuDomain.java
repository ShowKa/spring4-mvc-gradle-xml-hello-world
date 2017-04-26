package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.system.exception.SystemException;

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
public class KokyakuDomain extends AbstractDomain {

	// private member
	/** 顧客コード */
	private String code;

	/** 限定区分 */
	private GenteiKubun genteiKubun;

	/** 顧客区分 */
	private KokyakuKubun kokyakuKubun;

	/** 顧客名 */
	private String name;

	/** 住所 */
	private String address;

	/** 主幹部署 */
	private BushoDomain shukanBushoDomain;

	// public method
	/**
	 * 個人限定判定
	 * 
	 * @return 個人限定顧客ならtrue
	 */
	public boolean isKojinGentei() {
		if (isKojin() && GenteiKubun.限定 == genteiKubun) {
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
		if (KokyakuKubun.個人 == kokyakuKubun) {
			return true;
		}
		return false;
	}

	/**
	 * 法人判定
	 */
	public boolean isHojin() {
		if (KokyakuKubun.通常法人 == kokyakuKubun) {
			return true;
		}
		return false;
	}

	/**
	 * 顧客コードが一緒なら同値
	 */
	@Override
	protected boolean equals(AbstractDomain other) {
		KokyakuDomain o = (KokyakuDomain) other;
		return this.code.equals(o.code);
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public void validate() throws SystemException {
		// TODO Auto-generated method stub

	}

}
