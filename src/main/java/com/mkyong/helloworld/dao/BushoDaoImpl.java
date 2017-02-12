package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.BushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.builder.BushoDomainBuilder;
import com.mkyong.helloworld.entity.MBusho;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.JigyoKubun;

@Component
public class BushoDaoImpl extends AbstractDao<String, MBusho> implements BushoDao {

	@Override
	public BushoDomain getBushoDomain(String bushoCode) {
		// get data
		MBusho e = getByPrimaryKey(bushoCode);

		// 部署ドメイン生成
		BushoDomainBuilder builder = new BushoDomainBuilder();
		return builder.withBushoKubun(BushoKubun.valueOf(e.getBushoKubun()))
				.withCode(e.getCode())
				.withJigyoKubun(JigyoKubun.valueOf(e.getJigyoKubun()))
				.withName(e.getName())
				.withVersion(e.getVersion())
				.build();
	}

}
