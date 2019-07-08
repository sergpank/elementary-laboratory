package com.elementary.forum.servlets;

import com.elementary.forum.dao.TopicDao;
import com.elementary.forum.entites.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TopicsServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    PrintWriter writer = resp.getWriter();

    TopicDao dao = new TopicDao();
    List<Topic> topics = dao.loadAll();

    for(Topic t : topics)
    {
      writer.printf("<h1>%s</h1>\n", t.getTitle());
    }
  }
}
