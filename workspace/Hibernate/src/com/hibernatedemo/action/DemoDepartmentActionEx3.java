package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Department;
import com.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Department dep3 = new Department("Salesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
			
			session.save(dep3);
			
			session.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Something Wrong and ROLLBACK!!!");
			session.getTransaction().rollback();
			
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}