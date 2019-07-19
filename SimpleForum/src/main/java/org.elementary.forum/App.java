package org.elementary.forum;

import org.elementary.forum.dao.GroupDao;
import org.elementary.forum.dao.PostDao;
import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.entity.Group;
import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Topic;
import org.elementary.forum.entity.User;
import org.elementary.forum.entity.build.GroupBuilder;
import org.elementary.forum.entity.build.PostBuilder;
import org.elementary.forum.entity.build.TopicBuilder;
import org.elementary.forum.entity.build.UserBuilder;
import org.elementary.forum.dao.UserDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App
{
  public static void main(String[] args) throws IllegalAccessException
  {
    UserDao ud = new UserDao();
    TopicDao td = new TopicDao();
    GroupDao gd = new GroupDao();
    PostDao pd = new PostDao();

    Group g = new GroupBuilder().setName("users").build();
    gd.create(g);
    List<User> users = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
      String login = "user_" + i;
      String password = login + "_passwd";
      User u = new UserBuilder()
          .setLogin(login)
          .setPassword(password)
          .setRegistrationDate(new Date())
          .setGroup(g).build();
      ud.create(u);
      users.add(u);
    }

    List<Topic> topicList = new ArrayList<>();

    String[] titles = {"Lorem ipsum dolor sit amet.",
        "Soluta optio possimus reiciendis aspernatur.",
        "Dolor rerum cumque eum ipsam?",
        "Ipsam quo beatae quae vitae!",
        "Ad placeat nemo, autem expedita.",
        "Alias quam, corporis amet rem!",
        "Culpa repellendus cum ad incidunt!",
        "Eius harum, dignissimos hic ad!",
        "Dolorem dolor eligendi veniam minima.",
        "Blanditiis quidem dolor qui unde."};

    for (String title : titles)
    {
      int index = (int) (Math.random() * users.size());
      User u = users.get(index);

      Topic t = new TopicBuilder()
          .setTitle(title)
          .setDateCreated(new Date())
          .setAuthor(u).build();
      td.create(t);
      topicList.add(t);
    }

    String[] messages = null;
    File f = new File("files/posts.txt");
    if (f.exists())
    {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader reader = new BufferedReader(new FileReader(f)))
      {
        String line;
        while ((line = reader.readLine()) != null)
        {
          sb.append(line);
        }
        messages = sb.toString().split("@");

      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      return;
    }

    List<Post> posts = new ArrayList<>();

    for (String message : messages)
    {
      int userIndex = (int) (Math.random() * users.size());
      User u = users.get(userIndex);
      int topicIndex = (int) (Math.random() * topicList.size());
      Topic t = topicList.get(topicIndex);

      Post p = new PostBuilder()
          .setAuthor(u)
          .setDateCreated(new Date())
          .setText(message).setTopic(t).build();
      pd.create(p);
      posts.add(p);
    }

  }
}
