package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionFactoryListener implements ServletContextListener {

	public SessionFactoryListener() {
	}

	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtils.getSessionFactory();
		System.out.println("SessionFactory created!!!");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtils.closeSessionFactory();
		System.out.println("SessionFactory closed!!");
	}

}
