package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.entity.MKokyakuBushoId;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;

public class KokyakuTantoBushoServiceImpl implements KokyakuTantoBushoService {

	@Autowired
	KokyakuBushoDao kokyakuBushoDao;

	@Override
	public boolean existsTantoBusho(String kokyakuCode, String bushoCode) {
		MKokyakuBushoId id = new MKokyakuBushoId(kokyakuCode, bushoCode);
		MKokyakuBusho e = kokyakuBushoDao.getByPrimaryKey(id);
		if (e == null) {
			return false;
		}
		return true;
	}

}
