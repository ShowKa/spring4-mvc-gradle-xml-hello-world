package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoPK;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;
import com.mkyong.helloworld.system.exception.ApplicationException;

public class KokyakuTantoBushoServiceImpl implements KokyakuTantoBushoService {

	@Autowired
	KokyakuBushoDao kokyakuBushoDao;

	/**
	 * 担当部署存在チェック
	 */
	@Override
	public boolean existsTantoBusho(String kokyakuCode, String bushoCode) {
		MKokyakuTantoBushoPK id = new MKokyakuTantoBushoPK();
		id.setKokyakuCode(kokyakuCode);
		id.setBushoCode(bushoCode);
		MKokyakuTantoBusho e = kokyakuBushoDao.getByPrimaryKey(id);
		if (e == null) {
			return false;
		}
		return true;
	}

	/**
	 * 顧客担当部署整合性検証
	 */
	@Override
	public boolean validateKokyakuTantoBusho(KokyakuTantoBushoDomain kokyakuTantoBushoDomain) {
		KokyakuTantoBushoDomain d = kokyakuTantoBushoDomain;

		// 担当部署存在チェック
		boolean existsTantoBusho = existsTantoBusho(d.getKokyakuDomain().getCode(), d.getBudhoDomain().getCode());
		if (!existsTantoBusho) {
			throw new ApplicationException("AP01_0001");
		}

		// OK
		return true;
	}

	@Override
	public void update(KokyakuTantoBushoDomain domain) {
		// TODO Auto-generated method stub
	}

	@Override
	public void persist(KokyakuTantoBushoDomain domain) {
		// TODO Auto-generated method stub
	}

}
