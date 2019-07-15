package org.elementary.forum.servlets;

import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
      req.setAttribute("title", "Posts");
      long key = Long.parseLong(id);
      Topic topic = topicDao.read(key);
      topicDao.loadDependentProperty(topic,"posts");
      req.setAttribute("topic", topic);
      getServletContext().getRequestDispatcher("/single-topic-view.jsp").forward(req, resp);
    }
  }
}
