package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.NyukinKakeInfoDao;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.kubun.NyukinHohoKubun;
import com.mkyong.helloworld.service.i.NyukinKakeInfoService;
import com.mkyong.helloworld.system.exception.EmptyException;
import com.mkyong.helloworld.system.exception.WrongDateOrderException;

@Component
@Service
@Transactional
public class NyukinMotoKakeInfoServiceImpl implements NyukinKakeInfoService {

	@Autowired
	private NyukinKakeInfoDao nyukinKakeInfoDao;

	@Override
	public void register(NyukinKakeInfoDomain domain) {
		nyukinKakeInfoDao.register(domain);
	}

	@Override
	public void validate(NyukinKakeInfoDomain domain) {
		if (domain.getNyukinHohoKubun() == NyukinHohoKubun.NULL) {
			throw new EmptyException("販売方法");
		}
		// 締日 >= 入金日ならエラー
		if (!domain.shimeDateBeforeNyukinDate()) {
			throw new WrongDateOrderException("請求の締日", "入金日");
		}
	}

}