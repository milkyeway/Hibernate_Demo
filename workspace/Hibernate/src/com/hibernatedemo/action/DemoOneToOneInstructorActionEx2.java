package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Instructor;
import com.hibernatedemo.model.InstructorDetail;
import com.hibernatedemo.util.HibernateUtils;

public class DemoOneToOneInstructorActionEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor ins1 = session.get(Instructor.class, 1);

			InstructorDetail detail1 = ins1.getInstructorDetail();
			
			if(detail1 != null) {
				System.out.println(detail1.getId() + " " + detail1.getEmail() + " " + detail1.getPhone());
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}
}
