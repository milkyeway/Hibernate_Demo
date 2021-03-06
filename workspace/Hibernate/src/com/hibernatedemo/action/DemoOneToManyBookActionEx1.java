package com.hibernatedemo.action;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.BookUsers;
import com.hibernatedemo.model.Books;
import com.hibernatedemo.util.HibernateUtils;

public class DemoOneToManyBookActionEx1 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			// new book1
			Books book1 = new Books();
			book1.setBooktitle("Java 11");
			book1.setPublicYear("2018-1");

			// new book2
			Books book2 = new Books();
			book2.setBooktitle("One Punch");
			book2.setPublicYear("2023");

			// user
			BookUsers user1 = new BookUsers();
			user1.setUsername("Tom");

			// book set user
			book1.setBookuser(user1);
			book2.setBookuser(user1);

			// make book set
			Set<Books> bookSet = new LinkedHashSet<Books>();
			bookSet.add(book1);
			bookSet.add(book2);

			// user set book
			user1.setBooks(bookSet);

			session.save(user1);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}
}
