package org.elementary.forum.servlets;

import org.elementary.forum.dao.VotesDao;
import org.elementary.forum.entity.Votes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;

public class EditVotesServlet extends HttpServlet
{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String action=req.getParameter("action");
    String postId=req.getParameter("postId");
    String returnUrl=req.getParameter("returnUrl");
    int newValue=0;
    if(action !=null && postId!=null)
    {
      long key=Long.parseLong(postId);
      VotesDao votesDao=new VotesDao();
      Votes votes=votesDao.readByPostId(key);
      if(votes!=null)
      {
        switch(action)
        {
          case "up":
            newValue=votes.getUpVotes()+1;
            votes.setUpVotes(newValue);
            break;
          case "down":
            newValue=votes.getDownVotes()+1;
            votes.setDownVotes(newValue);
        }
        votesDao.update(votes);
      }
    }
    if(req.getHeader("X-Requested-With")!=null
        && req.getHeader("X-Requested-With").equals("XMLHttpRequest"))
    {
      resp.setContentType("text/plain");
      resp.setCharacterEncoding("UTF-8");
      Writer writer=resp.getWriter();
      writer.write(newValue+"");
      writer.close();
    }
    else
    {
      ServletContext servletContext=getServletContext();
      String nextUrl=returnUrl!=null? URLDecoder.decode(returnUrl, "UTF-8")
          : servletContext.getContextPath()+"/topics";
      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");
      resp.sendRedirect(nextUrl);
    }
  }
}
