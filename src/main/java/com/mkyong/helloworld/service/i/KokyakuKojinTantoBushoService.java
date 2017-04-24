package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;
import com.mkyong.helloworld.system.exception.ValidateException;

public interface KokyakuKojinTantoBushoService {
	/**
	 * 個人の顧客担当部署の整合性チェック
	 * 
	 * @param kokyakuTantoBushoDomain
	 * @return チェック結果
	 */
	public boolean validate(KokyakuKojinTantoBushoDomain domain);

	/**
	 * ドメイン登録
	 * 
	 * @param domain
	 */
	public void register(KokyakuKojinTantoBushoDomain domain);

	/**
	 * 販売部署の場合の整合性検証
	 * 
	 * @param domain
	 *            ドメイン
	 * @throws ValidateException
	 *             検証例外
	 */
	public void validateHanbaiBusho(KokyakuKojinTantoBushoDomain domain) throws ValidateException;

	/**
	 * レンタル部署の整合性検証
	 * 
	 * @param domain
	 *            ドメイン
	 * @throws ValidateException
	 *             検証例外
	 */
	public void validateRentalBusho(KokyakuKojinTantoBushoDomain domain) throws ValidateException;

}
