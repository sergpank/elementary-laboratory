package org.elementary.forum;

import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entites.Topic;
import org.elementary.forum.entites.User;

import java.util.Date;

public class MAIN
{
  public static void main(String[] args)
  {
    UserDao userDao = new UserDao();
    TopicDao topicDao = new TopicDao();

    for (int i = 1; i <=5; i++)
    {
      User user = new User();
      user.setLogin("user-" + i);
      user.setPassword("password-" + i);
      user.setRegistrationDate(new Date());

      userDao.save(user);
    }

    for (int i = 1; i <=5; i++)
    {
      Topic topic = new Topic();
      topic.setAuthor(userDao.getById(i));
      topic.setDateCreated(new Date());
      topic.setTitle("Topic-" + i);

      topicDao.save(topic);
    }

    topicDao.loadAll().forEach(System.out::println);
  }
}
