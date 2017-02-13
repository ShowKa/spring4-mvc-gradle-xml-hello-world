package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.BushoDao;
import com.mkyong.helloworld.dao.i.BushoDateDao;
import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.builder.BushoDomainBuilder;
import com.mkyong.helloworld.entity.MBusho;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.JigyoKubun;

@Component
public class BushoDaoImpl extends AbstractDao<String, MBusho> implements BushoDao {
	@Autowired
	BushoDateDao bushoDateDao;

	@Override
	public BushoDomain getBushoDomain(String bushoCode) {
		// 部署日付
		BushoDateDomain bushoDateDomain = bushoDateDao.getBushoDateDomain(bushoCode);

		// 部署ドメイン生成
		MBusho e = getByPrimaryKey(bushoCode);
		BushoDomainBuilder builder = new BushoDomainBuilder();
		return builder.withBushoKubun(BushoKubun.valueOf(e.getBushoKubun()))
				.withCode(e.getCode())
				.withJigyoKubun(JigyoKubun.valueOf(e.getJigyoKubun()))
				.withName(e.getName())
				.withBushoDateDomain(bushoDateDomain)
				.withVersion(e.getVersion())
				.build();
	}

}
