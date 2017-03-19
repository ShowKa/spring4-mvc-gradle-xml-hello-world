package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.NyukinKakeInfoDao;
import com.mkyong.helloworld.dao.i.NyukinMotoDao;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.domain.builder.NyukinMotoDomainBuilder;
import com.mkyong.helloworld.entity.MNyukinMoto;
import com.mkyong.helloworld.kubun.HanbaiKubun;

@Component
public class NyukinMotoDaoImpl extends AbstractDao<Integer, MNyukinMoto> implements NyukinMotoDao {

	@Autowired
	NyukinKakeInfoDao nyukinKakeInfoDao;

	@Override
	public NyukinMotoDomain getNyukinMotoDomain(Integer id) {
		MNyukinMoto e = getByPrimaryKey(id);
		NyukinMotoDomainBuilder builder = new NyukinMotoDomainBuilder();
		NyukinMotoDomain domain = builder.withHanbaiKubun(HanbaiKubun.valueOf(e.getHanbaiKubun()))
				.withId(e.getId())
				.withNyukinKakeInfoDomain(nyukinKakeInfoDao.getNyukinKakeInfoDomain(e.getId()))
				.withVersion(e.getVersion())
				.build();
		return domain;
	}

	/**
	 * ドメイン登録
	 */
	@Override
	public void register(NyukinMotoDomain domain) {
		MNyukinMoto e = new MNyukinMoto();

		// TODO
		e.setHanbaiKubun(domain.getHanbaiKubun().getCode());

		persist(e);
	}
}
