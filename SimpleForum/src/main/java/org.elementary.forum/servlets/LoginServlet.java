package org.elementary.forum.servlets;

import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    req.setAttribute("title", "Log In");
    ServletContext servletContext=getServletContext();
    RequestDispatcher requestDispatcher=servletContext.getRequestDispatcher("/login.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String login=req.getParameter("login");
    String password=req.getParameter("password");

    List<String> errors=new ArrayList<>();
    if(login==null || login.isEmpty())
    {
      errors.add("Empty login field");
    }
    if(password==null || password.isEmpty())
    {
      errors.add("Emty password field");
    }

    if(errors.size()==0)
    {
      UserDao userDao=new UserDao();
      User user=userDao.readByLogin(login);
      if(user==null)
      {
        errors.add("User with this login does not exist");
      }
      else if(!password.equals(user.getPassword()))
      {
        errors.add("Incorrect password");
      }
      else
      {
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
      }
    }
    if(errors.size()>0)
    {
      req.setAttribute("title", "Log In");
      req.setAttribute("errors", errors);
      User u=new User();
      u.setLogin(login);
      req.setAttribute("user", u);
      ServletContext servletContext=getServletContext();
      RequestDispatcher requestDispatcher=servletContext.getRequestDispatcher("/login.jsp");
      requestDispatcher.forward(req, resp);
    }
    else
    {
      String path=getServletContext().getContextPath()+"/topics";
      resp.sendRedirect(path);
    }
  }
}
