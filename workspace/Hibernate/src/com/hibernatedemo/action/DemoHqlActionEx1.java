package com.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernatedemo.model.Employee;
import com.hibernatedemo.util.HibernateUtils;

public class DemoHqlActionEx1 {
	public static void main(String[] args) {
		DemoHqlActionEx1 demoHql = new DemoHqlActionEx1();
//		demoHql.hqlSelectAll();
//		demoHql.hqlSelectSalary();
//		demoHql.hqlSelectSalary2(25000,3);
//		demoHql.hqlUpdateSalary(1,99999);
		demoHql.hqlDeleteSalary(3);
	}

//	查詢全部資料
	private void hqlSelectAll() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String hql = "from Employee";

			Query<Employee> query = session.createQuery(hql, Employee.class);

			List<Employee> list = query.getResultList();

			for (Employee oneBean : list) {
				System.out.println(oneBean);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}
	}

//	自訂查詢條件
	private void hqlSelectSalary() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String hql = "from Employee e where salary > 30000 and e.vacation > 10";

//			設置Query方法
			Query<Employee> query = session.createQuery(hql, Employee.class);

//			執行Qrery
			List<Employee> list = query.getResultList();

			for (Employee oneBean : list) {
				System.out.println(oneBean);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}
	}

//	使用變數帶入參數
	private void hqlSelectSalary2(int salary,int vacation) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String hql = "from Employee e where salary > :s and e.vacation > :v";

//			設置Query方法
			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("s",salary)
					.setParameter("v",vacation);
//			執行Qrery
			List<Employee> list = query.getResultList();

			for (Employee oneBean : list) {
				System.out.println(oneBean);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}
	}

//	利用變數變更資料
	private void hqlUpdateSalary(int id, int salary) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql = "update Employee set salary = :salary where id = :id"; 
			
		    session.createQuery(hql)
		    	.setParameter("salary", salary)
					.setParameter("id", id)
					.executeUpdate();
					
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
	}
	
//	利用變數刪除資料
	private void hqlDeleteSalary(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql = "delete Employee where id = :id"; 
			
		    session.createQuery(hql)
					.setParameter("id", id)
					.executeUpdate();
					
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
	}
	
}
