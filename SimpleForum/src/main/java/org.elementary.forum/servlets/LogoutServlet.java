package org.elementary.forum.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

public class LogoutServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String returnUrl=req.getParameter("returnUrl");
    returnUrl=returnUrl!=null? URLDecoder.decode(returnUrl,"UTF-8")
        : getServletContext().getContextPath()+"/topics";
    HttpSession session=req.getSession();
    session.removeAttribute("user");
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    resp.sendRedirect(returnUrl);
  }
}
