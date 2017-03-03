package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoPK;

@Component
public class KokyakuBushoDaoImpl extends AbstractDao<MKokyakuTantoBushoPK, MKokyakuTantoBusho>
		implements KokyakuBushoDao {

}
