package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.NyukinMotoDao;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.service.i.NyukinMotoService;

public class NyukinMotoServiceImpl implements NyukinMotoService {

	@Autowired
	NyukinMotoDao nyukinMotoDao;

	/**
	 * 整合性判定
	 */
	@Override
	public void validate(NyukinMotoDomain domain) {
	}

	/**
	 * ドメイン登録
	 */
	@Override
	public void register(NyukinMotoDomain domain) {
		nyukinMotoDao.register(domain);
	}

}
