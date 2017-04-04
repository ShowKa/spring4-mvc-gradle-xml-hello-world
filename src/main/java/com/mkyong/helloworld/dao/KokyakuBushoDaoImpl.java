package com.mkyong.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.BushoDao;
import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.dao.i.KokyakuDao;
import com.mkyong.helloworld.dao.i.NyukinMotoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.domain.builder.KokyakuTantoBushoDomainBuilder;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoId;
import com.mkyong.helloworld.entity.MNyukinMoto;
import com.mkyong.helloworld.kubun.ShohizeiKubun;

@Component
public class KokyakuBushoDaoImpl extends AbstractDao<MKokyakuTantoBushoId, MKokyakuTantoBusho>
		implements KokyakuBushoDao {

	// dao
	@Autowired
	private BushoDao bushoDao;

	@Autowired
	private KokyakuDao kokyakuDao;

	@Autowired
	private NyukinMotoDao nyukinMotoDao;

	/**
	 * ドメイン取得
	 */
	@Override
	public KokyakuTantoBushoDomain getDomain(String kokyakuCode, String bushoCode) {

		// get entity
		MKokyakuTantoBushoId id = new MKokyakuTantoBushoId();
		id.setKokyakuCode(kokyakuCode);
		id.setBushoCode(bushoCode);
		MKokyakuTantoBusho e = this.getByPrimaryKey(id);

		// other domains
		BushoDomain bushoDomain = bushoDao.getBushoDomain(bushoCode);
		KokyakuDomain kokyakuDomain = kokyakuDao.getDomain(kokyakuCode);
		// FIXME get domain by entity
		NyukinMotoDomain nyukinMotoDomain = nyukinMotoDao.getNyukinMotoDomain(e.getMNyukinMoto().getId());

		// FIXME build domain
		KokyakuTantoBushoDomainBuilder b = new KokyakuTantoBushoDomainBuilder();
		b.withBushoDomain(bushoDomain);
		b.withKokyakuDomain(kokyakuDomain);
		b.withKokyakuTantoBushoHanbaiDomain(null);
		b.withKokyakuTantoBushoRentalDomain(null);
		b.withNyukinMotoDomain(nyukinMotoDomain);
		b.withSeikyuSakiDomain(null);
		b.withSekininshaName(e.getSekininshaName());
		b.withShohizeiKubun(ShohizeiKubun.valueOf(e.getShohizeiKubun()));
		b.withVersion(e.getVersion());
		return b.build();
	}

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
