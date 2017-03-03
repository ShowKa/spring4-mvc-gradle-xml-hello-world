package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoPK;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.NotExistException;

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

		// 担当部署
		BushoDomain tantoBusho = d.getBudhoDomain();

		// 担当部署存在チェック
		boolean existsTantoBusho = existsTantoBusho(d.getKokyakuDomain().getCode(), tantoBusho.getCode());
		if (!existsTantoBusho) {
			throw new NotExistException("担当部署", tantoBusho.getCode());
		}

		// 担当部署の区分チェック
		if (tantoBusho.getBushoKubun() != BushoKubun.営業所) {
			throw new IncorrectKubunException("担当部署", tantoBusho.getBushoKubun());
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
