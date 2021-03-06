package com.elementary.forum.dao;

import com.elementary.forum.entites.Post;
import com.elementary.forum.entites.Topic;
import com.elementary.forum.entites.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory()
  {
    if(sessionFactory == null)
    {
      try
      {
        Configuration configuration = new Configuration().configure();

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Topic.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }
}
