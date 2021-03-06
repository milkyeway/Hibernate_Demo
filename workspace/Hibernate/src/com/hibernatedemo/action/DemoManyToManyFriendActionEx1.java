package com.hibernatedemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.Friend;
import com.hibernatedemo.model.MyGroup;
import com.hibernatedemo.util.HibernateUtils;

public class DemoManyToManyFriendActionEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			MyGroup workGroup = session.get(MyGroup.class, 3);
			System.out.println(workGroup);
			Set<Friend> friends = workGroup.getFriends();
			System.out.println(friends);

			Iterator<Friend> it = friends.iterator();
			System.out.println(it);

			while (it.hasNext()) {
				Friend friend = it.next();
				String name = friend.getFriendName();
				System.out.println("friend.getFriendName(): " + name);

				if (name.equals("Tina")) {
					it.remove();
				}
			}

			Friend bill = new Friend();
			System.out.println(bill);
			bill.setFriendName("Bill");
//			 session.save(bill); // ?i?ٲ?

			friends.add(bill);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}
}
