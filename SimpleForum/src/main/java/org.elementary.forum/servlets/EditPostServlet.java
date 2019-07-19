package org.elementary.forum.servlets;

import org.elementary.forum.dao.PostDao;
import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Topic;
import org.elementary.forum.entity.User;
import org.elementary.forum.entity.build.PostBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditPostServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    if(req.getSession().getAttribute("user")==null)
    {
      resp.sendRedirect(getServletContext().getContextPath()+"/login");
    }

    String returnUrl=req.getParameter("returnUrl");
    returnUrl=(returnUrl!=null && !returnUrl.isEmpty())? returnUrl :
        URLEncoder.encode(getServletContext().getContextPath()+"/topics","UTF-8");

    String topicId=req.getParameter("topicId");
    String parentId=req.getParameter("parentId");

    req.setAttribute("title", "Create post");
    req.setAttribute("topicId", topicId);
    req.setAttribute("parentId", parentId);
    req.setAttribute("returnUrl", returnUrl);
    ServletContext context=getServletContext();
    RequestDispatcher requestDispatcher=context.getRequestDispatcher("/create-post.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String postId=req.getParameter("postId");
    String returnUrl=req.getParameter("returnUrl");
    String parentId=req.getParameter("parentId");
    String topicId=req.getParameter("topicId");
    String text=req.getParameter("text");

    List<String> errors=new ArrayList<>();
    PostDao postDao=new PostDao();

    if(postId!=null && !postId.isEmpty())
    {
      long key=Long.parseLong(postId);
      postDao.delete(key);
    }
    else
    {
      HttpSession session=req.getSession();
      User author=(session.getAttribute("user")!=null)? (User)session.getAttribute("user") : null;
      if(text==null)
      {
        errors.add("Сообщение не может быть пустым");
      }
      if(topicId==null || author==null)
      {
        errors.add("К сожалению, что-то пошло не так... Попробуйте оставить сообщение в другой раз.");
      }
      if(errors.size()==0)
      {
        long topicKey=Long.parseLong(topicId);
        TopicDao topicDao=new TopicDao();
        Topic topic=topicDao.read(topicKey);
        Post parent=null;
        if(parentId!=null)
        {
          long parentKey=Long.parseLong(parentId);
          parent=postDao.read(parentKey);
        }
        try
        {
          Post post=new PostBuilder()
              .setAuthor(author)
              .setDateCreated(new Date())
              .setText(text)
              .setTopic(topic)
              .setParent(parent)
              .build();
          postDao.create(post);
        }
        catch (IllegalAccessException e)
        {
          e.printStackTrace();
        }
      }
    }
    if(errors.size()==0)
    {
      ServletContext context=getServletContext();
      returnUrl=(returnUrl!=null && !returnUrl.isEmpty())? URLDecoder.decode(returnUrl, "UTF-8") :
          context.getContextPath()+"/topics";
      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");
      resp.sendRedirect(returnUrl);
    }
    else
    {
      req.setAttribute("title", "Create post");
      req.setAttribute("topicId", topicId);
      req.setAttribute("parentId", parentId);
      req.setAttribute("returnUrl", returnUrl);
      req.setAttribute("errors", errors);
      ServletContext context=getServletContext();
      RequestDispatcher requestDispatcher=context.getRequestDispatcher("/create-post.jsp");
      requestDispatcher.forward(req,resp);
    }

  }


}
