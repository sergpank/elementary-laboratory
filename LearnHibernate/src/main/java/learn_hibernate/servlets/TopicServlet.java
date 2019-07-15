package learn_hibernate.servlets;

import learn_hibernate.dao.TopicDao;
import learn_hibernate.entity.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TopicServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    TopicDao topicDao = new TopicDao();
    String id = req.getParameter("id");
    if (id == null)
    {
      List<Topic> topicList = topicDao.readAll();
      req.setAttribute("topicList", topicList);
      getServletContext().getRequestDispatcher("/topic-view.jsp").forward(req, resp);
    }
    else
    {
      long key = Long.parseLong(id);
      Topic topic = topicDao.read(key);
      req.setAttribute("topic", topic);
      getServletContext().getRequestDispatcher("/single-topic-view.jsp").forward(req, resp);
    }
  }
}
