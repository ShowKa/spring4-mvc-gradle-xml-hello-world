package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.NyukinKakeInfoDao;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.service.i.NyukinKakeInfoService;

@Component
@Service
@Transactional
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