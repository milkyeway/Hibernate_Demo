package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Instructor;
import com.hibernatedemo.model.InstructorDetail;
import com.hibernatedemo.util.HibernateUtils;

public class DemoOneToOneInstructorActionEx3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor ins2 = session.get(Instructor.class, 2);

			InstructorDetail detail2 = ins2.getInstructorDetail();

			if (detail2 != null) {
				System.out.println("���b�R��: " + detail2.getInstructor().getName());
				System.out.println(detail2);
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
