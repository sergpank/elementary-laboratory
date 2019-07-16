package learn_hibernate.servlets;

import learn_hibernate.dao.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppLifeCycleListener implements ServletContextListener
{
  @Override
  public void contextInitialized(ServletContextEvent sce)
  {
    HibernateUtil.getSessionFactory();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce)
  {
    HibernateUtil.shutdown();
  }
}
