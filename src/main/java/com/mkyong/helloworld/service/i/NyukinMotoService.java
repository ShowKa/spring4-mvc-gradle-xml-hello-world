package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.NyukinMotoDomain;

public interface NyukinMotoService {

	/**
	 * 整合性判定.
	 */
	public void validate(NyukinMotoDomain domain);

	/**
	 * ドメイン登録
	 * 
	 * @param domain
	 */
	public void register(NyukinMotoDomain domain);
}
