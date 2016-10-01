package com.mkyong.helloworld.dao;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core-config.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public abstract class DaoTestCaseBase {

}
