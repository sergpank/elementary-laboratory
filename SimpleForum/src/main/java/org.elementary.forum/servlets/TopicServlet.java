package org.elementary.forum.servlets;

import org.elementary.forum.dao.PostDao;
import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopicServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    TopicDao topicDao = new TopicDao();
    String id = req.getParameter("id");
    if (id == null)
    {
      req.setAttribute("title", "Topics");
      List<Topic> topicList = topicDao.readAll();
      req.setAttribute("topicList", topicList);
      getServletContext().getRequestDispatcher("/topics-view.jsp").forward(req, resp);
    }
    else
    {
      PostDao postDao=new PostDao();
      req.setAttribute("title", "Posts");
      long key = Long.parseLong(id);
      Topic topic = topicDao.read(key);
      topic=topicDao.loadDependentProperty(topic,"posts");

      for(Post p : topic.getPosts())
      {
        postDao.loadDependentProperty(p, "children");
      }
      req.setAttribute("topic", topic);
      getServletContext().getRequestDispatcher("/single-topic-view.jsp").forward(req, resp);
    }
  }
}
