package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuDomain;

public interface KokyakuService {

	/**
	 * 顧客コード存在判定
	 * 
	 * @param kokykuCode
	 *            顧客コード
	 * @return 存在するならtrue
	 */
	public boolean existsKokyaku(String kokykuCode);

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
	public boolean validate(KokyakuDomain domain);

	/**
	 * 法人顧客データとして正しいか検証する
	 * 
	 * @param domain
	 *            顧客ドメイン
	 * @return 検証結果
	 */
	public boolean validateKokyakuHojin(KokyakuDomain domain);

	/**
	 * 顧客ドメイン取得
	 * 
	 * @param kokyakuCode
	 *            顧客コード
	 * @return 顧客ドメイン
	 */
	public KokyakuDomain getKokyakuDomain(String kokyakuCode);

}
