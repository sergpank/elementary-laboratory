package learn_hibernate.dao;

import learn_hibernate.entity.Post;
import learn_hibernate.entity.Topic;
import org.hibernate.Session;

import java.util.List;

public class TopicDao extends AbstractDao<Topic>
{
  @Override
  public Topic read(long id)
  {
    Long key=Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    Topic topic=session.get(Topic.class, key);
    if(topic!=null)
    {
      loadPosts(topic);
    }
    session.close();
    return topic;
  }

  @Override
  public List<Topic> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Topic> topics=session.createQuery("from Topic").list();
    for(Topic t: topics)
    {
      loadPosts(t);
    }
    session.close();
    return topics;
  }

  private void loadPosts(Topic topic)
  {
    for(Post p : topic.getPosts());
  }
}
