package org.elementary.forum.servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;

public class CurrentUrlFilter implements Filter
{
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
  {
    HttpServletRequest request=(HttpServletRequest) servletRequest;
    request.setCharacterEncoding("UTF-8");
    String currentUrl=request.getRequestURI()+(request.getQueryString()==null? "" : "?"+request.getQueryString());
    servletRequest.setAttribute("currentUrl", currentUrl);
    servletRequest.setAttribute("url", URLEncoder.encode(currentUrl, "UTF-8"));
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException
  {

  }

  @Override
  public void destroy()
  {

  }
}
