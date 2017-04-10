package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain;
import com.mkyong.helloworld.system.exception.ValidateException;

public interface KokyakuTantoBushoHanbaiService {
	/**
	 * 顧客担当 販売部署の整合性チェック
	 * 
	 * @param domain
	 *            ドメイン
	 */
	public void validate(KokyakuTantoBushoHanbaiDomain domain) throws ValidateException;

	/**
	 * 
	 * 顧客担当 販売部署新規登録
	 * 
	 * @param domain
	 *            ドメイン
	 */
	public void register(KokyakuTantoBushoHanbaiDomain domain);
}
