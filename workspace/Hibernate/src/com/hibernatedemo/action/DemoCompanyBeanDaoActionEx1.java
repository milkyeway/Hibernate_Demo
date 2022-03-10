package com.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.model.CompanyBean;
import com.hibernatedemo.model.CompanyDao;
import com.hibernatedemo.model.CompanyDaoInterface;
import com.hibernatedemo.util.HibernateUtils;

public class DemoCompanyBeanDaoActionEx1 {

	/* �T�h���[�c
	/* 1.��{�h (Presentation layer) JSP
	 * 2.�~���޿�h (Business layer) Service
	 * 3.��ƳX�ݼh (Data access layer) DAO
	 */
	
	/* �����[�c
	/* MVC
	 * �T�h���[�c
	 * ��ؤ@�_�ϥ�
	 */
	 	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
//			���V�����]�p
			CompanyDaoInterface dao = new CompanyDao(session);
			
//			�s�W�浧
//			dao.insert(new CompanyBean(1003,"twitter"));
			
//			�ܧ�浧
//			dao.updateOne(1003, "Block");
//			CompanyBean com1 = dao.select(1003);			
//			if(com1!=null) {
//				System.out.println(com1.getCompanyId()+ " " + com1.getCompanyName());
//			}
			
//			�R���浧
//			boolean boo = dao.deleteOne(1003);
//			System.out.println(boo);
			
//			�j�M����
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
