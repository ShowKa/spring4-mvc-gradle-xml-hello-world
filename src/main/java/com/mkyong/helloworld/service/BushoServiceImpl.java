package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.helloworld.dao.i.BushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.service.i.BushoService;

@Service
public class BushoServiceImpl implements BushoService {

	@Autowired
	BushoDao bushoDao;

	@Override
	public BushoDomain getBushoDomain(String bushoCode) {
		return bushoDao.getBushoDomain(bushoCode);
	}
}
