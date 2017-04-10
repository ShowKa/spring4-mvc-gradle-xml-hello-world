package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.BlockNumber;
import com.mkyong.helloworld.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuTantoBushoHanbaiDomain extends AbstractDomain {

	// private members
	/** 顧客ドメイン */
	private KokyakuDomain kokyakuDomain;

	/** 部署ドメイン */
	private BushoDomain bushoDomain;

	/** ブロックナンバー */
	private BlockNumber blockNumber;

	/** バージョン（排他制御用） */
	private Integer version;

	// public method
	@Override
	protected boolean equals(AbstractDomain other) {
		KokyakuTantoBushoHanbaiDomain o = (KokyakuTantoBushoHanbaiDomain) other;
		return (this.kokyakuDomain.equals(o.kokyakuDomain) && this.bushoDomain.equals(o.bushoDomain));
	}

	@Override
	public int hashCode() {
		return generateHashCode(this.kokyakuDomain.hashCode(), this.bushoDomain.hashCode());
	}

	@Override
	public void validate() throws SystemException {
	}

	/**
	 * 不定期巡回か判定
	 * 
	 * @return 不定期巡回（ブロック=ZZ)ならtrue
	 */
	public boolean isHuteiki() {
		return blockNumber.isHuteiki();
	}
}
