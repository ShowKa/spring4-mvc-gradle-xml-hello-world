package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.ShohizeiKubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuTantoBushoDomain extends AbstractDomain {

	// private members
	/** 顧客ドメイン */
	private KokyakuDomain kokyakuDomain;

	/** 部署ドメイン */
	private BushoDomain budhoDomain;

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

	@Override
	protected boolean equals(AbstractDomain other) {
		KokyakuTantoBushoDomain o = (KokyakuTantoBushoDomain) other;
		return (this.kokyakuDomain.equals(o.kokyakuDomain) && this.budhoDomain.equals(o.budhoDomain));
	}

	@Override
	public int hashCode() {
		return generateHashCode(this.kokyakuDomain.hashCode(), this.budhoDomain.hashCode());
	}
}
