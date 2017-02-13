package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.BushoDateDao;
import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.domain.builder.BushoDateDomainBuilder;
import com.mkyong.helloworld.entity.MBushoDate;
import com.mkyong.helloworld.value.EigyoDate;
import com.mkyong.helloworld.value.KeijyoDate;

@Component
public class BushoDateDaoImpl extends AbstractDao<String, MBushoDate> implements BushoDateDao {

	@Override
	public BushoDateDomain getBushoDateDomain(String bushoCode) {
		MBushoDate e = getByPrimaryKey(bushoCode);
		BushoDateDomainBuilder b = new BushoDateDomainBuilder();
		return b.withBushoCode(e.getBushoCode())
				.withEigyoDate(new EigyoDate(e.getEigyoDate()))
				.withKeijoDate(new KeijyoDate(e.getKeijoDate()))
				.withVersion(e.getVersion())
				.build();
	}

}
