package com.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Instructor;
import com.hibernatedemo.model.InstructorDetail;
import com.hibernatedemo.util.HibernateUtils;

public class DemoOneToOneInstructorActionEx6 {
	// Mary 回來，要把 Detail 加回去
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor ins2 = session.get(Instructor.class, 2);

			InstructorDetail detail2 = new InstructorDetail("mary@gmail", "666");
//				session.save(detail2);

			// detail2 會自動轉換成 Persistent 狀態
			ins2.setInstructorDetail(detail2);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}
}
