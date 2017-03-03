package com.mkyong.helloworld.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.OptimisticLockException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.helloworld.entity.AbstractEntity;

@Component
public abstract class AbstractDao<PK extends Serializable, T extends AbstractEntity> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByPrimaryKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void delete(PK key, int version) {
		T e = getByPrimaryKey(key);
		if (e.getVersion() != version) {
			throw new OptimisticLockException();
		}
		delete(e);
	}

	protected Criteria createEntityCriteria() {
		Criteria criteria = getSession().createCriteria(persistentClass);
		criteria.setMaxResults(1000);
		return criteria;
	}

	protected Criteria createEntityCriteriaUnlimited() {
		return getSession().createCriteria(persistentClass);
	}

}