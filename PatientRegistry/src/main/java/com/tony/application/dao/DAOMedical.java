package com.tony.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.tony.application.hibernateUtil.HibernateUtil;
import com.tony.application.models.MedicalStaff;
import com.tony.application.models.Patient;

@Repository
public class DAOMedical implements MedicalDataBase {

	@Override
	public void addMedical(MedicalStaff medicalStaff) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(medicalStaff);
		tx.commit();
		session.close();
	}

	@Override
	public void updateMedical(MedicalStaff medicalStaff) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(medicalStaff);
		tx.commit();
		session.close();
	}
	
	@Override
	public MedicalStaff retrieveStaffMember(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		return (MedicalStaff) session.createQuery("from MedicalStaff where med_id = " + id).uniqueResult();
	}

	@Override
	public MedicalStaff retrieveUniqueMedical(String email, String password) {

		MedicalStaff medicalStaff = new MedicalStaff();
		String queryString = "from MedicalStaff where user_name = " + "'" + email + "'" + " and password = " + "'"
				+ password + "'";
		List<MedicalStaff> list = new ArrayList<MedicalStaff>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			list = session.createQuery(queryString).getResultList();
		} catch (NoResultException | NullPointerException e) {

		}

		session.close();

		if (!list.isEmpty())
			return list.get(0);
		else {
			medicalStaff = null;
			return medicalStaff;
		}
	}

	@Override
	public void deleteMedical(MedicalStaff medicalStaff) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(medicalStaff);
		tx.commit();
		session.close();
	}


}














