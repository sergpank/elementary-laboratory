package org.elementary.forum.dao;

import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Topic;
import org.elementary.forum.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends AbstractDao<User>
{
  @Override
  public User read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    User user = session.get(User.class, key);
    session.close();
    return user;
  }

  @Override
  public List<User> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<User> users = session.createQuery("from User as u order by e.login").list();
    session.close();
    return users;
  }

  @Override
  public User loadDependentProperty(User item, String propName)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.update(item);
    if(propName.equals("posts"))
    {
      for(Post p : item.getPosts())
      {

      }
    }
    else if(propName.equals("topics"))
    {
      for (Topic t : item.getTopics())
      {

      }
    }
    session.close();
    return item;
  }

  public User readByLogin(String login)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<User> users = session.createQuery("from User as u where u.login= :login")
        .setParameter("login", login)
        .list();
    session.close();
    return users.size()>0? users.get(0) : null;
  }

  public boolean loginExists(String login)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<User> users = session.createQuery("select u.id from User as u where u.login= :login")
        .setParameter("login", login)
        .list();
    session.close();
    return users.size()>0;
  }

}
