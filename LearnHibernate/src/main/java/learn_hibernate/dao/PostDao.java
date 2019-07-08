package learn_hibernate.dao;

import learn_hibernate.entity.Post;
import org.hibernate.Session;

import java.util.List;

public class PostDao extends AbstractDao<Post>
{
  @Override
  public Post read(long id)
  {
    Long key=Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    Post post=session.get(Post.class, key);
    session.close();
    return post;
  }

  @Override
  public List<Post> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Post> posts=session.createQuery("from Post").list();
    session.close();
    return posts;
  }
}
