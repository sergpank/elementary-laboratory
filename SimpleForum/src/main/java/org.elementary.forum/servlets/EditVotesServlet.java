package org.elementary.forum.servlets;

import org.elementary.forum.dao.VotesDao;
import org.elementary.forum.entity.Votes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditVotesServlet extends HttpServlet
{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String action=req.getParameter("action");
    String postId=req.getParameter("postId");
    String returnUrl=req.getParameter("returnUrl");
    if(action !=null && postId!=null)
    {
      long key=Long.parseLong(postId);
      VotesDao votesDao=new VotesDao();
      Votes votes=votesDao.readByPostId(key);

    }
  }
}
