package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.SeikyuKubun;
import com.mkyong.helloworld.kubun.SeikyushoSakuseiBashoKubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SeikyuSakiDomain extends AbstractDomain {

	// private members
	/** ID */
	private Integer id;

	/** 請求先名 */
	private String seikyuSaskiName;

	/** 請求区分 */
	private SeikyuKubun seikyuKubun;

	/** 請求書作成場所 */
	private SeikyushoSakuseiBashoKubun seikyushoSakuseiBashoKubun;

	/** バージョン（排他制御用) */
	private Integer version;

	// public method

	@Override
	protected boolean equals(AbstractDomain other) {
		SeikyuSakiDomain o = (SeikyuSakiDomain) other;
		return id.equals(o.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
