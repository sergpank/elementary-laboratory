package org.elementary.forum.dao;

import org.elementary.forum.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao
{
  public User getById(long id)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    User user = session.get(User.class, id);
    session.close();

    return user;
  }

  public User save(User user)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    // SAVE HERE
    session.saveOrUpdate(user);

    session.getTransaction().commit();
    session.close();

    return user;
  }

  public List<User> loadAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Criteria criteria = session.createCriteria(User.class);
    List users = criteria.list();
//    List users = session.createQuery("from User").list();

    session.close();

    return users;
  }
}
