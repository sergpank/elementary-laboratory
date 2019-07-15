package org.elementary.forum.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SimpleServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
  throws IOException
  {
    PrintWriter out = resp.getWriter();
    String str="<html><head><title>Greeteing</title><body><h1>Привет! " +new Date()+
        "</body></head></html>";
    out.print(str);
    out.flush();
    out.close();
  }

}
