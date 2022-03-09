package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernatedemo.model.Department;
import com.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx6 {
//	session get() method
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Department dept1 = session.get(Department.class, 2);
			
			System.out.println("id: " + dept1.getDeptid()); // 2
			System.out.println("department name: " + dept1.getDeptname()); // RD

			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			
		}finally {
			HibernateUtils.closeSessionFactory();
		}

	}


}