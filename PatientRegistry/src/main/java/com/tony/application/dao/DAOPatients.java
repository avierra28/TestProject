package com.tony.application.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.tony.application.hibernateUtil.HibernateUtil;
import com.tony.application.models.Patient;

@Repository
public class DAOPatients implements PatientDataBase {

	@Override
	public void addPatient(Patient patient) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(patient);
		tx.commit();
		session.close();
	}

	@Override
	public List<Patient> getAllPatients() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		return session.createQuery("from Patient").list();
	}

	@Override
	public List<Patient> getSortedPatients(String query) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		return session.createQuery(query).list();
	}

	@Override
	public Patient retrieveUniquePatient(int id) {

		String queryString = "from Patient where id = " + id;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		return (Patient) session.createQuery(queryString).uniqueResult();

	}
	
	@Override
	public void updatePatient(Patient patient) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(patient);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deletePatient(Patient patient) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(patient);
		tx.commit();
		session.close();
	}
}
