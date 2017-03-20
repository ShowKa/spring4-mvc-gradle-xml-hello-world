package com.mkyong.helloworld.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoId;
import com.mkyong.helloworld.entity.MNyukinMoto;
import com.mkyong.helloworld.entity.MSeikyuSaki;

public class KokyakuBushoDaoImplTest extends DaoTestCaseBase {

	@Autowired
	private KokyakuBushoDao kokyakuBushoDao;

	@Test
	public void testPersist() {
		MKokyakuTantoBusho e = new MKokyakuTantoBusho();

		// id
		MKokyakuTantoBushoId id = new MKokyakuTantoBushoId();
		id.setBushoCode("002");
		id.setKokyakuCode("001");
		e.setId(id);

		// others
		e.setSekininshaName("責任者だよ");
		e.setShohizeiKubun("00");

		// nyukin
		MNyukinMoto nyukinMoto = new MNyukinMoto();
		nyukinMoto.setId(2);
		e.setMNyukinMoto(nyukinMoto);

		// seikyu
		MSeikyuSaki seikyuSaki = new MSeikyuSaki();
		seikyuSaki.setId(1);
		e.setMSeikyuSaki(seikyuSaki);

		// persist
		// kokyakuBushoDao.persist(e);
	}

	@Test
	public void testUpdate() {
		MKokyakuTantoBusho e = new MKokyakuTantoBusho();

		// id
		MKokyakuTantoBushoId id = new MKokyakuTantoBushoId();
		id.setBushoCode("002");
		id.setKokyakuCode("001");
		e.setId(id);

		// others
		e.setSekininshaName("責任者だよ");
		e.setShohizeiKubun("00");

		// nyukin
		MNyukinMoto nyukinMoto = new MNyukinMoto();
		nyukinMoto.setId(1);
		e.setMNyukinMoto(nyukinMoto);

		// seikyu
		MSeikyuSaki seikyuSaki = new MSeikyuSaki();
		seikyuSaki.setId(1);
		e.setMSeikyuSaki(seikyuSaki);

		// version
		e.setVersion(1);

		// persist
		// kokyakuBushoDao.update(e);
	}
}
