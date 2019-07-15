package org.elementary.forum.dao;

import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Topic;
import org.hibernate.Session;

import java.util.List;

public class TopicDao extends AbstractDao<Topic>
{
  @Override
  public Topic read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    Topic topic = session.get(Topic.class, key);
    session.close();
    return topic;
  }

  @Override
  public List<Topic> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Topic> topics = session.createQuery("from Topic as t order by t.dateCreated desc").list();
    session.close();
    return topics;
  }

  @Override
  public Topic loadDependentProperty(Topic item, String propName)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.update(item);
    if(propName.equals("posts"))
    {
      for(Post p : item.getPosts())
      {

      }
    }
    session.close();
    return item;
  }
}
