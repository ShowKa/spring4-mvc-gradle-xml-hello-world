package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.NyukinKakeInfoDao;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.domain.builder.NyukinKakeInfoDomainBuilder;
import com.mkyong.helloworld.entity.MNyukinKakeInfo;
import com.mkyong.helloworld.kubun.NyukinHohoKubun;
import com.mkyong.helloworld.kubun.NyukinTsukiKubun;

@Component
public class NyukinKakeInfoDaoImpl extends AbstractDao<Integer, MNyukinKakeInfo> implements NyukinKakeInfoDao {

	@Override
	public NyukinKakeInfoDomain getNyukinKakeInfoDomain(Integer id) {
		MNyukinKakeInfo e = getByPrimaryKey(id);
		NyukinKakeInfoDomainBuilder builder = new NyukinKakeInfoDomainBuilder();
		NyukinKakeInfoDomain domain = builder.withId(e.getId())
				.withNyukinDate(e.getNyukinDate())
				.withNyukinHohoKubun(NyukinHohoKubun.valueOf(e.getNyukinHohoKubun()))
				.withNyukinTsukiKubun(NyukinTsukiKubun.valueOf(e.getNyukinTsukiKubun()))
				.withShimeDate(e.getShimebi())
				.withVersion(e.getVersion())
				.build();
		return domain;
	}

}
