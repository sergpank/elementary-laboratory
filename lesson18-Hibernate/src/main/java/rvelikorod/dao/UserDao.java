package rvelikorod.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.hillel.rvelikorod.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao
{
  public User getById(long id)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    User user = session.get(User.class, id);
//    session.close();

    return user;
  }

  public User save (User user)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();

    // SAVE HERE
    session.save(user);

    session.getTransaction().commit();
//    session.close();

    return user;
  }

  public List<User> loadAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Criteria criteria = session.createCriteria(User.class);
    List users = criteria.list();
//    List users = session.createQuery("from User").list();

//    for (Object u : users)
//    {
//      System.out.printf("%d - %s\n", ((User)u).getId(), ((User)u).getPosts());
//    }

    session.close();

    return users;
  }
}
