package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.NyukinKakeInfoDao;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.service.i.NyukinKakeInfoService;

public class NyukinMotoKakeInfoServiceImpl implements NyukinKakeInfoService {

	@Autowired
	private NyukinKakeInfoDao NyukinKakeInfoDao;

	@Override
	public void register(NyukinKakeInfoDomain domain) {
		NyukinKakeInfoDao.register(domain);
	}

	@Override
	public void validate(NyukinKakeInfoDomain domain) {
	}

}