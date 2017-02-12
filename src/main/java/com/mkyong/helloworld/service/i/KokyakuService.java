package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuDomain;

public interface KokyakuService {
	/**
	 * 顧客ドメイン登録
	 * 
	 * @param domain
	 *            顧客ドメイン
	 * @return 登録成否
	 */
	public boolean register(KokyakuDomain domain);

	/**
	 * 顧客データとして正しいか検証する
	 * 
	 * @param domain
	 *            顧客ドメイン
	 * @return 検証結果
	 */
	public boolean validateHojinKokyaku(KokyakuDomain domain);
}
