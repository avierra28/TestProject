package com.tony.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tony.hibernateutil.HibernateUtil;
import com.tony.vo.Bean;

@Repository
@Component
public class BeanDAO implements DAOInterface {

	private ArrayList<Bean> beans;

	@Autowired
	private Bean bean;

	public void addBean(Bean bean) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.save(bean);
		transaction.commit();
		session.close();
	}

	public ArrayList<Bean> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		beans = (ArrayList<Bean>) session.createCriteria(Bean.class).list();
		session.close();
		return beans;
	}

	public Bean retrieveUniqueBean(String id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		bean = (Bean) session.get(Bean.class, id);
		transaction.commit();
		session.close();
		return bean;
	}

	public void deleteRecord(Bean bean) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(bean);
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

	public void restDelete(String id) {

		//String hql = "delete from records where id =" + id;
		Bean myBean = new Bean();
		myBean.setIdString(id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(myBean);
		transaction.commit();
		session.close();
	}

}
