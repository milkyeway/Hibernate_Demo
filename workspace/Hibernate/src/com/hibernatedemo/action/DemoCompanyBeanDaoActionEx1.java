package com.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.CompanyBean;
import com.hibernatedemo.model.CompanyDao;
import com.hibernatedemo.model.CompanyDaoInterface;
import com.hibernatedemo.util.HibernateUtils;

public class DemoCompanyBeanDaoActionEx1 {

	/* 三層式架構
	/* 1.表現層 (Presentation layer) JSP
	 * 2.業務邏輯層 (Business layer) Service
	 * 3.資料訪問層 (Data access layer) DAO
	 */
	
	/* 網頁架構
	/* MVC
	 * 三層式架構
	 * 兩種一起使用
	 */
	 	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
//			面向介面設計
			CompanyDaoInterface dao = new CompanyDao(session);
			
//			新增單筆
//			dao.insert(new CompanyBean(1003,"twitter"));
			
//			變更單筆
//			dao.updateOne(1003, "Block");
//			CompanyBean com1 = dao.select(1003);			
//			if(com1!=null) {
//				System.out.println(com1.getCompanyId()+ " " + com1.getCompanyName());
//			}
			
//			刪除單筆
//			boolean boo = dao.deleteOne(1003);
//			System.out.println(boo);
			
//			搜尋全部
			List<CompanyBean> list = dao.selectAll();
			for(CompanyBean com : list) {
				System.out.println(com.getCompanyId() + " " + com.getCompanyName());
			}
			
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Something Wrong and rollback!!");
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}
}
