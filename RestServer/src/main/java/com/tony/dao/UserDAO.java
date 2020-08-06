package com.tony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tony.hibernateutil.HibernateUtil;
import com.tony.vo.Bean;

public class UserDAO {

	public Bean getUser(String id) {

		Bean bean = new Bean();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		bean = (Bean) session.get(Bean.class, id);
		transaction.commit();
		session.close();
		return bean;

	}

	public void createUser(Bean bean) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bean);
		transaction.commit();
		session.close();

	}

	public void updateRecord(Bean bean) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(bean);
		transaction.commit();
		session.close();
	}
	
	public void deleteRecord(String id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Bean bean = session.load(Bean.class, id);
		session.delete(bean);
		transaction.commit();
		session.close();
	}
	
	public List<Bean> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Bean> beans = session.createCriteria(Bean.class).list();
		session.close();
		return beans;
	}
}
