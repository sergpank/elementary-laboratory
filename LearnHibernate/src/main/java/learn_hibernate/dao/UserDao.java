package learn_hibernate.dao;

import learn_hibernate.entity.Post;
import learn_hibernate.entity.Topic;
import learn_hibernate.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends AbstractDao<User>
{
  @Override
  public User read(long id)
  {
    Long key=Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    User user = session.get(User.class, key);
    if(user!=null)
    {
      loadTopics(user);
      loadPosts(user);
    }
    session.close();
    return user;
  }

  @Override
  public List<User> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<User> users=session.createQuery("from User").list();
    for(User u: users)
    {
      loadTopics(u);
      loadPosts(u);
    }
    session.close();
    return users;
  }

  private void loadPosts(User user)
  {
    for(Post p: user.getPosts());
  }
  private void loadTopics(User user)
  {
    for(Topic t: user.getTopics());
  }
}
