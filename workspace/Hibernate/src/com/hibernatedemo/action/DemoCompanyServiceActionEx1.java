package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.CompanyBean;
import com.hibernatedemo.service.CompanyService;
import com.hibernatedemo.util.HibernateUtils;

public class DemoCompanyServiceActionEx1 {
	
	public static void main(String[] args) {
		SessionFactory factory =  HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			CompanyService comService = new CompanyService(session);
			
			CompanyBean oneBean = comService.select(1001);
			System.out.println(oneBean.getCompanyId() + " " + oneBean.getCompanyName());
			
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
	}
	
}
