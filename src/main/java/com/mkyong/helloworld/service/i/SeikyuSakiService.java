package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.SeikyuSakiDomain;

public interface SeikyuSakiService {

	/**
	 * 整合性判定.
	 */
	public void validate(SeikyuSakiDomain domain);

	/**
	 * ドメイン登録
	 * 
	 * @param domain
	 */
	public void register(SeikyuSakiDomain domain);
}
