package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KyujitsuDao;
import com.mkyong.helloworld.domain.value.DateWithoutTime;
import com.mkyong.helloworld.entity.MKyujitsu;
import com.mkyong.helloworld.entity.MKyujitsuPK;
import com.mkyong.helloworld.service.i.BushoDateService;

public class BushoDateServiceImpl implements BushoDateService {

	@Autowired
	private KyujitsuDao kyujitsuDao;

	@Override
	public boolean isEigyoDate(String bushoCode, DateWithoutTime date) {

		// 部署の休日情報取得
		MKyujitsuPK id = new MKyujitsuPK();
		id.setBushoCode(bushoCode);
		id.setKyujitsu(date.toDate());
		MKyujitsu kyujitsu = kyujitsuDao.getByPrimaryKey(id);

		// 判定
		if (kyujitsu == null) {
			return true;
		} else {
			return false;
		}
	}
}
