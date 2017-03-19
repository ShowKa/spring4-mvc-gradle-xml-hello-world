package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoPK;

@Component
public class KokyakuBushoDaoImpl extends AbstractDao<MKokyakuTantoBushoPK, MKokyakuTantoBusho>
		implements KokyakuBushoDao {

	/**
	 * ドメイン登録
	 */
	@Override
	public void register(KokyakuTantoBushoDomain domain) {

		KokyakuDomain kokyaku = domain.getKokyakuDomain();
		BushoDomain busho = domain.getBushoDomain();

		MKokyakuTantoBushoPK id = new MKokyakuTantoBushoPK();
		id.setKokyakuCode(kokyaku.getCode());
		id.setBushoCode(busho.getCode());

		MKokyakuTantoBusho e = new MKokyakuTantoBusho();
		e.setId(id);
		e.setSekininshaName(domain.getSekininshaName());
		e.setShohizeiKubun(domain.getShohizeiKubun().getCode());

		persist(e);
	}

}
