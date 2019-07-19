package org.elementary.forum.dao;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.maven.artifact.versioning.Restriction;
import org.elementary.forum.entity.Post;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class PostDao extends AbstractDao<Post>
{
  @Override
  public Post read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Post post = session.get(Post.class, key);
    session.getTransaction().commit();
    session.close();
    return post;
  }

  @Override
  public List<Post> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Post> posts=session.createQuery("from Post as p where p.parent is null order by p.dateCreated desc")
        .list();
    session.getTransaction().commit();
    session.close();
    return posts;
  }

  @Override
  public Post loadDependentProperty(Post item, String propName)
  {

    if(propName.equals("children"))
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<Post> children=session.createQuery("from Post as p where p.parent.id= :key order by p.dateCreated desc")
          .setParameter("key", item.getId())
          .list();
      item.setChildren(children);

      session.getTransaction().commit();
      session.close();

      for(Post p : children)
      {
        loadDependentProperty(p, propName);
      }
    }
    return item;
  }

  public List<Post> readAllByTopicId(long topicId)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Post> posts=
        session.createQuery("from Post as p where p.topic.id= :key and p.parent is null order by p.dateCreated desc")
            .setParameter("key", topicId)
            .list();
    session.getTransaction().commit();
    session.close();
    return posts;
  }
}
