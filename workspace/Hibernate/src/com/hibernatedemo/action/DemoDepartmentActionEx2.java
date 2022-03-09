package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Department;
import com.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Department d2 = new Department("RD");
		
		session.save(d2);
		
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtils.closeSessionFactory();

	}

}