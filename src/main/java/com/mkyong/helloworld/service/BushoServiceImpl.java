package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.BushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.entity.MBusho;
import com.mkyong.helloworld.service.i.BushoService;

@Component
@Service
@Transactional
public class BushoServiceImpl implements BushoService {

	@Autowired
	BushoDao bushoDao;

	@Override
	public BushoDomain getBushoDomain(String bushoCode) {
		return bushoDao.getBushoDomain(bushoCode);
	}

	/**
	 * 部署存在チェック
	 */
	@Override
	public boolean existsBusho(String bushoCode) {
		MBusho e = bushoDao.getByPrimaryKey(bushoCode);
		return (e != null);
	}
}
