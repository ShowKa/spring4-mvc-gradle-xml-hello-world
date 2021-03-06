package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.ShohizeiKubun;
import com.mkyong.helloworld.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuTantoBushoDomain extends AbstractDomain {

	// private members
	/** 顧客ドメイン */
	private KokyakuDomain kokyakuDomain = KokyakuDomain.EMPTY;

	/** 担当部署の部署ドメイン */
	private BushoDomain bushoDomain = BushoDomain.EMPTY;

	/** 消費税区分 */
	private ShohizeiKubun shohizeiKubun = ShohizeiKubun.EMPTY;

	/** 責任者名 */
	private String sekininshaName = STRING_EMPTY;

	/** 顧客担当部署販売ドメイン */
	private KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain = KokyakuTantoBushoHanbaiDomain.EMPTY;

	/** 顧客担当部署レンタルドメイン */
	private KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain = KokyakuTantoBushoRentalDomain.EMPTY;

	/** 入金元 */
	private NyukinMotoDomain nyukinMotoDomain;

	/** 請求先 */
	private SeikyuSakiDomain seikyuSakiDomain;

	/** バージョン（排他制御用） */
	private int version = 0;

	// public method
	@Override
	protected boolean equals(AbstractDomain other) {
		KokyakuTantoBushoDomain o = (KokyakuTantoBushoDomain) other;
		return (this.kokyakuDomain.equals(o.kokyakuDomain) && this.bushoDomain.equals(o.bushoDomain));
	}

	@Override
	public int hashCode() {
		return generateHashCode(this.kokyakuDomain.hashCode(), this.bushoDomain.hashCode());
	}

	@Override
	public void validate() throws SystemException {
		if (bushoDomain.isHanbaiJigyoBusho()) {
			if (kokyakuTantoBushoHanbaiDomain == null) {
				throw new SystemException("顧客担当部署販売ドメインが設定されていません。");
			}
		}
		if (bushoDomain.isRentalJigyoBusho()) {
			if (kokyakuTantoBushoRentalDomain == null) {
				throw new SystemException("顧客担当部署レンタルドメインが設定されていません。");
			}
		}
	}

	/**
	 * 主幹判定
	 * 
	 * @return 担当部署が顧客の主幹ならtrue
	 */
	public boolean isShukan() {
		return kokyakuDomain.getShukanBushoDomain().getCode().equals(this.bushoDomain.getCode());
	}

	/**
	 * 販売部署判定
	 * 
	 * @return 担当部署の事業が販売の場合true
	 */
	public boolean isHanbaiBusho() {
		return bushoDomain.isHanbaiJigyoBusho();
	}

	/**
	 * レンタル部署判定
	 * 
	 * @return 担当部署の事業がレンタルの場合true
	 */
	public boolean isRentalBusho() {
		return bushoDomain.isRentalJigyoBusho();
	}

}
