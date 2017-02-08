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
	public boolean existsTantoBusho(String kokyakuCode, String bushoCode);

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
