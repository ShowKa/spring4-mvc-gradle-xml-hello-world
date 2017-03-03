package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.BushoDomain;

public interface BushoService {

	/**
	 * 部署ドメイン取得
	 * 
	 * @param bushoCode
	 *            部署コード
	 * @return 部署ドメイン
	 */
	public BushoDomain getBushoDomain(String bushoCode);

	/**
	 * 部署存在チェック
	 * 
	 * @param bushoCode
	 *            部署コード
	 * @return 部署が存在するならtrue
	 */
	public boolean existsBusho(String bushoCode);

}
