package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;

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
	 * 法人顧客データとして正しいか検証する
	 * 
	 * @param domain
	 *            顧客ドメイン
	 * @return 検証結果
	 */
	public boolean validateKokyakuHojin(KokyakuDomain domain);
	
	/**
	 * 個人顧客データとして正しいか検証する
	 * 
	 * @param domain
	 *            個人顧客ドメイン
	 * @return 検証結果
	 */
	public boolean validateKokyakuKojin(KokyakuKojinDomain domain);
	
	/**
	 * 顧客データとして正しいか検証する
	 * <pre>全顧客区分で行う共通処理</pre>
	 * 
	 * @param domain
	 *            顧客ドメイン
	 * @return 検証結果
	 */
	public boolean validateKokyaku(KokyakuDomain domain);
}
