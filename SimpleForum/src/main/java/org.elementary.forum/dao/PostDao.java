package org.elementary.forum.dao;

import org.elementary.forum.entity.Post;
import org.hibernate.Session;

import java.util.List;

public class PostDao extends AbstractDao<Post>
{
  @Override
  public Post read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    Post post = session.get(Post.class, key);
    session.close();
    return post;
  }

  @Override
  public List<Post> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Post> posts = session.createQuery("from Post as p order by p.dateCreated desc").list();
    session.close();
    return posts;
  }

  @Override
  public Post loadDependentProperty(Post item, String propName)
  {
    return item;
  }
}
