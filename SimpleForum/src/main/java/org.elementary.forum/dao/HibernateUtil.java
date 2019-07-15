package org.elementary.forum.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil
{
  private static SessionFactory sessionFactory;

  protected static SessionFactory buildSessionFactory()
  {
    final StandardServiceRegistry registry=new StandardServiceRegistryBuilder()
        .configure()
        .build();
    try
    {
      sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    catch (Exception e)
    {
      StandardServiceRegistryBuilder.destroy(registry);
      throw new ExceptionInInitializerError("Initial session factory failed"+e);
    }
    return sessionFactory;
  }

  public static SessionFactory getSessionFactory()
  {
    if(sessionFactory==null)
    {
      sessionFactory=buildSessionFactory();
    }
    return sessionFactory;
  }

  public static void shutdown()
  {
    if(sessionFactory!=null)
    {
      sessionFactory.close();
    }
  }
}
