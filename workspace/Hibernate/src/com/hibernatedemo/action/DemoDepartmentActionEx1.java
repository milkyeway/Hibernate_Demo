package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernatedemo.model.Department;

public class DemoDepartmentActionEx1 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
//		開連線 (工廠模式）
		Session session = factory.openSession();
//		開交易
		session.beginTransaction();
		
		Department depart1 = new Department();
		depart1.setDeptname("RD");
		session.save(depart1);
		
		
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}