package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoId;
import com.mkyong.helloworld.entity.MNyukinMoto;

@Component
public class KokyakuBushoDaoImpl extends AbstractDao<MKokyakuTantoBushoId, MKokyakuTantoBusho>
		implements KokyakuBushoDao {

	/**
	 * ドメイン登録
	 */
	@Override
	public void register(KokyakuTantoBushoDomain domain) {

		KokyakuDomain kokyaku = domain.getKokyakuDomain();
		BushoDomain busho = domain.getBushoDomain();

		MKokyakuTantoBushoId id = new MKokyakuTantoBushoId();
		id.setKokyakuCode(kokyaku.getCode());
		id.setBushoCode(busho.getCode());

		MKokyakuTantoBusho e = new MKokyakuTantoBusho();
		e.setId(id);
		e.setSekininshaName(domain.getSekininshaName());
		e.setShohizeiKubun(domain.getShohizeiKubun().getCode());

		MNyukinMoto nyukinMoto = new MNyukinMoto();
		nyukinMoto.setId(domain.getNyukinMotoDomain().getId());
		e.setMNyukinMoto(nyukinMoto);

		persist(e);
	}

}
