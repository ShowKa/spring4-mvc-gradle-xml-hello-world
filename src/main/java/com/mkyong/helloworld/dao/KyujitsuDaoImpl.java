package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.KyujitsuDao;
import com.mkyong.helloworld.entity.MKyujitsu;
import com.mkyong.helloworld.entity.MKyujitsuPK;

@Component
public class KyujitsuDaoImpl extends AbstractDao<MKyujitsuPK, MKyujitsu> implements KyujitsuDao {

}
