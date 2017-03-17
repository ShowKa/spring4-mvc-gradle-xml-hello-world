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
	private KokyakuDomain kokyakuDomain;

	/** 担当部署の部署ドメイン */
	private BushoDomain bushoDomain;

	/** 消費税区分 */
	private ShohizeiKubun shohizeiKubun;

	/** 責任者名 */
	private String sekininshaName;

	/** 顧客担当部署販売ドメイン */
	private KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain;

	/** 顧客担当部署レンタルドメイン */
	private KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain;

	/** 入金元 */
	private NyukinMotoDomain nyukinMotoDomain;

	/** 請求先 */
	private SeikyuSakiDomain seikyuSakiDomain;

	/** バージョン（排他制御用） */
	private int version;

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
}
