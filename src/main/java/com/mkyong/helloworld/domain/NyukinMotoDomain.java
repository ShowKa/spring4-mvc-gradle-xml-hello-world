package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.HanbaiKubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NyukinMotoDomain extends AbstractDomain {

	/** ID */
	Integer id;

	/** 販売区分 */
	HanbaiKubun hanbaiKubun;

	/** 入金掛売情報 */
	NyukinKakeInfo nyukinKakeInfo;

	/** バージョン（排他制御用) */
	Integer version;

	@Override
	public boolean isEmpty() {
		return hanbaiKubun == null;
	}

	@Override
	protected boolean equals(AbstractDomain other) {
		NyukinMotoDomain o = (NyukinMotoDomain) other;
		// FIXME
		return id == o.id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
