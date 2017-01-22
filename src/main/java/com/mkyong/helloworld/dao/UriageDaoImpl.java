package com.mkyong.helloworld.dao;

import org.springframework.stereotype.Component;

import com.mkyong.helloworld.dao.i.UriageDao;
import com.mkyong.helloworld.entity.Uriage;

@Component
public class UriageDaoImpl extends AbstractDao<String, Uriage> implements UriageDao {

}