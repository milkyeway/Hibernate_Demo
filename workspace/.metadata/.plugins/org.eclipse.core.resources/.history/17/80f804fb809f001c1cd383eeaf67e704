package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Department;
import com.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			
			Department dep = new Department("Toyz");
			
	        session.save(dep);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			
		} finally {
			session.close();
			HibernateUtils.closeSessionFactory();
		}

	}

}