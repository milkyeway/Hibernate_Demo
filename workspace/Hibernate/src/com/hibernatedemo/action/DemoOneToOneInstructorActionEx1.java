package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Instructor;
import com.hibernatedemo.model.InstructorDetail;
import com.hibernatedemo.util.HibernateUtils;

public class DemoOneToOneInstructorActionEx1 {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor ins1 = new Instructor("Jeff");
			
			InstructorDetail detail1 = new InstructorDetail("Jeff@gmail", "888");
			
			ins1.setInstructorDetail(detail1);
			
			// �� cascadeType.All ���]�w�A�]�|�ഫ detail �����A,�u�ݤ@��save()
			session.save(ins1);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}
}