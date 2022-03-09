package com.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeenActionEx2 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
//		�}�s�u (�u�t�Ҧ��^
		Session session = factory.openSession();
//		�}���
		session.beginTransaction();
		
		CompanyBean com2 = new CompanyBean(1002,"Meta");
		
//		�|�^�Ǥ@��id ���O�O Serializable
		Serializable id = session.save(com2);
		
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}