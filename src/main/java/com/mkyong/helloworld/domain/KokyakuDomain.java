package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 顧客ドメイン
 * 
 * @author ShowKa
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KokyakuDomain extends AbstractDomain {

	// private member
	/** 顧客コード */
	private String code = STRING_EMPTY;

	/** 限定区分 */
	private GenteiKubun genteiKubun = GenteiKubun.EMPTY;;

	/** 顧客区分 */
	private KokyakuKubun kokyakuKubun = KokyakuKubun.EMPTY;

	/** 顧客名 */
	private String name = STRING_EMPTY;

	/** 住所 */
	private String address = STRING_EMPTY;

	/** 主幹部署 */
	private BushoDomain shukanBushoDomain = BushoDomain.EMPTY;

	public KokyakuDomain(String code) {
		System.out.println(this.code);
		this.code = code;
		System.out.println(this.code);
	}

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
	 * 空チェック
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this instanceof EmptyKokyakuDomain;
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
	}

	// Empty
	public static final KokyakuDomain EMPTY = EmptyKokyakuDomain.INSTANCE;

}

/**
 * Empty
 * 
 * @author ShowKa
 *
 */
class EmptyKokyakuDomain extends KokyakuDomain {
	public static final EmptyKokyakuDomain INSTANCE = new EmptyKokyakuDomain();

	private EmptyKokyakuDomain() {
		super();
	}
}