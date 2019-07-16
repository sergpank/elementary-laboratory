package org.elementary.forum.servlets;

import org.elementary.forum.dao.HibernateUtil;

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
