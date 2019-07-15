package org.elementary.forum.servlets;

import org.elementary.forum.dao.GroupDao;
import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entity.Group;
import org.elementary.forum.entity.User;
import org.elementary.forum.entity.build.UserBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    req.setAttribute("title", "Registration");
    ServletContext servletContext=getServletContext();
    RequestDispatcher requestDispatcher=servletContext.getRequestDispatcher("/register.jsp");
    requestDispatcher.forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String login=req.getParameter("login");
    String password=req.getParameter("password");
    String confirmPassword=req.getParameter("confirm_password");
    List<String> errors=new ArrayList<>();
    if(login==null || login.isEmpty())
    {
      errors.add("Empty login field");
    }
    if(password==null || password.isEmpty())
    {
      errors.add("Emty password field");
    }
    if(confirmPassword==null || confirmPassword.isEmpty() || password!=null && !confirmPassword.equals(password))
    {
      errors.add("Fields password and confirm password don't match");
    }
    if(errors.size()==0)
    {
      UserDao userDao=new UserDao();
      if(userDao.loginExists(login))
      {
        errors.add("The user with a same login already exists");
      }
      else
      {
        GroupDao groupDao=new GroupDao();
        Group usersGroup=groupDao.readByName("users");
        try
        {
          User user = new UserBuilder()
              .setGroup(usersGroup)
              .setLogin(login)
              .setPassword(password)
              .setRegistrationDate(new Date())
              .build();
          userDao.create(user);
        }
        catch (IllegalAccessException e)
        {
          e.printStackTrace();
        }
      }
    }
    if(errors.size()>0)
    {
      req.setAttribute("title", "Registration");
      req.setAttribute("errors", errors);
      User u=new User();
      u.setLogin(login);
      req.setAttribute("user", u);
      ServletContext servletContext=getServletContext();
      RequestDispatcher requestDispatcher=servletContext.getRequestDispatcher("/register.jsp");
      requestDispatcher.forward(req, resp);
    }
    else
    {
      req.setAttribute("title", "Registration success");
      String path=getServletContext().getContextPath()+"/registration-success.jsp";
      resp.sendRedirect(path);
    }
  }
}
