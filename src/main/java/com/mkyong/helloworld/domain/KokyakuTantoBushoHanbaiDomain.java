package com.mkyong.helloworld.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuTantoBushoHanbaiDomain extends AbstractDomain {

	// private members
	/** 顧客ドメイン */
	private KokyakuDomain kokyakuDomain;

	/** 部署ドメイン */
	private BushoDomain budhoDomain;

	/** ブロックナンバー */
	private String blockNumber;

	/** バージョン（排他制御用） */
	private Integer version;

	// public method
	@Override
	protected boolean equals(AbstractDomain other) {
		KokyakuTantoBushoHanbaiDomain o = (KokyakuTantoBushoHanbaiDomain) other;
		return (this.kokyakuDomain.equals(o.kokyakuDomain) && this.budhoDomain.equals(o.budhoDomain));
	}

	@Override
	public int hashCode() {
		return generateHashCode(this.kokyakuDomain.hashCode(), this.budhoDomain.hashCode());
	}
}
