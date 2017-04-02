package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuKojinDomain;

public interface KokyakuKojinService {

	/**
	 * 個人顧客データとして正しいか検証する
	 * <pre>
	 * 以下の条件を満たす。
	 * 区分=個人
	 * 親顧客が設定されている
	 * この個人顧客の担当部署 ∈ 親納品先の担当部署一覧
	 * </pre>
	 * 
	 * @param domain
	 *            個人顧客ドメイン
	 * @return 検証結果
	 */
	public boolean validateKokyakuKojin(KokyakuKojinDomain domain);
	
	/**
	 * 顧客個人ドメイン登録
	 * 
	 * @param domain
	 *            顧客個人ドメイン
	 * @return 登録成否
	 */
	public boolean registerKokyakuKojin(KokyakuKojinDomain domain);

}
