package org.elementary.forum;

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
  throws IOException, SecurityException
  {
    PrintWriter writer = resp.getWriter();
    writer.println("<html><head><meta charset=\"UTF-8\"><head>");
    writer.println("<body><h1>"+ new Date()+ "</h1></body></html>");
    writer.flush();
    writer.close();
  }
}

