package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernatedemo.model.Department;
import com.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx5 {
//	Get Transaction object
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Department dep = new Department("clothes");

			session.save(dep);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();

		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}