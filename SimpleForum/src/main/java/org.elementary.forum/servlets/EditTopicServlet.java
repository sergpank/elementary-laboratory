package org.elementary.forum.servlets;

import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.entity.Topic;
import org.elementary.forum.entity.User;
import org.elementary.forum.entity.build.TopicBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditTopicServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    if(req.getSession().getAttribute("user")==null)
    {
      resp.sendRedirect(getServletContext().getContextPath()+"/login");
    }
    String returnUrl=req.getParameter("returnUrl");
    req.setAttribute("title", "Create topic");
    req.setAttribute("returnUrl", returnUrl);
    ServletContext context=getServletContext();
    RequestDispatcher requestDispatcher=context.getRequestDispatcher("/create-post.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String topicId=req.getParameter("topicId");
    String text=req.getParameter("text");
    String returnUrl=req.getParameter("returnUrl");

    List<String> errors=new ArrayList<>();
    TopicDao topicDao=new TopicDao();

    if(topicId!=null && !topicId.isEmpty())
    {
      long key=Long.parseLong(topicId);
      topicDao.delete(key);
    }
    else
    {
      HttpSession session=req.getSession();
      User author=(session.getAttribute("user")!=null)? (User)session.getAttribute("user") : null;
      if(text==null)
      {
        errors.add("Сообщение не может быть пустым");
      }
      if(author==null)
      {
        errors.add("К сожалению, что-то пошло не так... Попробуйте добавить тему в другой раз.");
      }
      if(errors.size()==0)
      {
        try
        {
          Topic topic=new TopicBuilder()
              .setAuthor(author)
              .setTitle(text)
              .setDateCreated(new Date())
              .build();
          topicDao.create(topic);
        }
        catch (IllegalAccessException e)
        {
          e.printStackTrace();
        }
      }
    }
    if(errors.size()==0)
    {
      returnUrl=returnUrl!=null? URLDecoder.decode(returnUrl, "UTF-8")
          :getServletContext().getContextPath()+"/topics";
      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");
      resp.sendRedirect(returnUrl);
    }
    else
    {
      req.setAttribute("title", "Create post");
      req.setAttribute("errors", errors);
      req.setAttribute("returnUrl", returnUrl);
      ServletContext context=getServletContext();
      RequestDispatcher requestDispatcher=context.getRequestDispatcher("/create-topic.jsp");
      requestDispatcher.forward(req,resp);
    }
  }
}
