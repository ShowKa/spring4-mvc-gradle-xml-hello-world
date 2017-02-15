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

	/** バージョン（排他制御用） */
	private int version;

	@Override
	public boolean isEmpty() {
		// FIXME
		return false;
	}

	@Override
	protected boolean equals(AbstractDomain other) {
		// FIXME
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
