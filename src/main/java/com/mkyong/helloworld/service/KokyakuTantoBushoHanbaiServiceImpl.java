package com.mkyong.helloworld.service;

import com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoHanbaiService;
import com.mkyong.helloworld.system.exception.EmptyException;
import com.mkyong.helloworld.system.exception.ValidateException;

public class KokyakuTantoBushoHanbaiServiceImpl implements KokyakuTantoBushoHanbaiService {

	@Override
	public void validate(KokyakuTantoBushoHanbaiDomain domain) throws ValidateException {
		if (domain.getBlockNumber() == null) {
			throw new EmptyException("ブロックNo");
		}
	}

	@Override
	public void register(KokyakuTantoBushoHanbaiDomain domain) {

	}

}
