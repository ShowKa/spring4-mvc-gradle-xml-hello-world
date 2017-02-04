package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.entity.MKokyakuBushoPK;

public class KokyakuBushoDaoImpl extends AbstractDao<MKokyakuBushoPK, MKokyakuBusho> implements KokyakuBushoDao {

	@Autowired
	private KokyakuDao kokyakuDao;

	@Override
	public KokyakuTantoBushoDomain getKokyakuTantoBushoDomain(MKokyakuBushoPK id) {
		MKokyakuBusho e = getByPrimaryKey(id);
		KokyakuDomain d = kokyakuDao.getKokyakuDomain(id.getKokyakuCode());
		return new KokyakuTantoBushoDomain(e, d);
	}

}
