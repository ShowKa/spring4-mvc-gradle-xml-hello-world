package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.HanbaiKubun;
import com.mkyong.helloworld.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NyukinMotoDomain extends AbstractDomain {

	// private members
	/** ID */
	Integer id;

	/** 販売区分 */
	HanbaiKubun hanbaiKubun;

	/** 入金掛売情報 */
	NyukinKakeInfoDomain nyukinKakeInfoDomain;

	/** バージョン（排他制御用) */
	Integer version;

	// public method
	/**
	 * 入金元整合性判定
	 * 
	 * <pre>
	 * 現金販売なのに掛売り情報がある場合はfalse。
	 * 掛売りなのに掛売り情報がない場合はfalse
	 * </pre>
	 * 
	 * @return 判定結果
	 */
	public boolean validateNyukinMoto() {
		if (hanbaiKubun == HanbaiKubun.掛売) {
			return nyukinKakeInfoDomain != null;
		}
		if (hanbaiKubun == HanbaiKubun.現金) {
			return nyukinKakeInfoDomain == null;
		}
		return true;
	}

	@Override
	protected boolean equals(AbstractDomain other) {
		NyukinMotoDomain o = (NyukinMotoDomain) other;
		return id.equals(o.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public void validate() throws SystemException {
		// TODO Auto-generated method stub

	}

}
