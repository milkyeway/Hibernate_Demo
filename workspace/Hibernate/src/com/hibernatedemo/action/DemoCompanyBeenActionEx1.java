package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeenActionEx1 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		CompanyBean com1 = new CompanyBean();
		com1.setCompanyId(1001);
		com1.setCompanyName("Tesla");
		
		session.save(com1);
		
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
