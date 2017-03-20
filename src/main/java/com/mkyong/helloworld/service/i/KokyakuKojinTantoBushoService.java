package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;

public interface KokyakuKojinTantoBushoService {
	/**
	 * 個人の顧客担当部署の整合性チェック
	 * 
	 * @param kokyakuTantoBushoDomain
	 * @return チェック結果
	 */
	public boolean validate(KokyakuKojinTantoBushoDomain domain);

}
