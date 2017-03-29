package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.NyukinMotoDao;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.kubun.HanbaiKubun;
import com.mkyong.helloworld.service.i.NyukinKakeInfoService;
import com.mkyong.helloworld.service.i.NyukinMotoService;

@Component
@Service
@Transactional
public class NyukinMotoServiceImpl implements NyukinMotoService {

	@Autowired
	private NyukinMotoDao nyukinMotoDao;

	@Autowired
	private NyukinKakeInfoService nyukinKakeInfoService;

	/**
	 * 整合性判定
	 */
	@Override
	public void validate(NyukinMotoDomain domain) {
		HanbaiKubun hanbaiKubun = domain.getHanbaiKubun();
		if (hanbaiKubun == HanbaiKubun.掛売) {
			nyukinKakeInfoService.validate(domain.getNyukinKakeInfoDomain());
		}
	}

	/**
	 * ドメイン登録
	 */
	@Override
	public void register(NyukinMotoDomain domain) {
		nyukinMotoDao.register(domain);
	}

}
