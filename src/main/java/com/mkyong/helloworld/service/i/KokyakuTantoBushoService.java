package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;

public interface KokyakuTantoBushoService {
	/**
	 * 顧客に、すでに担当部署が登録されているかチェックする
	 * 
	 * @param kokyakuCode
	 *            顧客コード
	 * @param bushoCode
	 *            部署コード
	 * @return チェック結果
	 */
	public boolean existsKokyakuTantoBusho(String kokyakuCode, String bushoCode);

	/**
	 * 顧客担当部署の整合性チェック
	 * 
	 * @param kokyakuTantoBushoDomain
	 * @return チェック結果
	 */
	public boolean validateKokyakuTantoBusho(KokyakuTantoBushoDomain kokyakuTantoBushoDomain);

	/**
	 * 顧客担当部署情報更新
	 * 
	 * @param domain
	 *            顧客担当部署ドメイン
	 */
	public void update(KokyakuTantoBushoDomain domain);

	/**
	 * 顧客担当部署新規登録
	 * 
	 * @param domain
	 *            顧客担当部署ドメイン
	 */
	public void persist(KokyakuTantoBushoDomain domain);
}
