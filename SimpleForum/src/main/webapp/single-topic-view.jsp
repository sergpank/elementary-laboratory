<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page errorPage="error-page.jsp"%>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<main>
	<c:if test="${topic == null}">
	    <h2>The topic was not found</h2>
	</c:if>
	<c:if test="${topic != null}">
		<h2 class="display-4 bg-light">${topic.title}</h2>
		 <p>Author of topic: ${topic.author.login}; Created: ${topic.dateCreated}</p>
		 <h3>Posts:</h3>
		<%=renderPostList(((Topic)request.getAttribute("topic")).getPosts(),
			request.getAttribute("url"),
			session.getAttribute("user"),
			application.getContextPath())%>
	</c:if>
</main>
<jsp:include page="foot.jsp" />

<%@page import="java.util.*, org.elementary.forum.entity.*" %>
<%!
	String renderPostList(Object postList, Object returnUrl, Object user, String root)
	{
		List<Post> posts=(List<Post>)postList;
		User usr=user!=null? (User)user : null;
		String rUrl=(String)returnUrl;
		StringBuilder sb=new StringBuilder();

		for(Post p : posts)
		{
			sb.append("<div class=\"card\">");

			sb.append("<div class=\"card-header text-light bg-dark clearfix\">");
			sb.append("<div class=\"float-left\">Author: "+p.getAuthor().getLogin()+"</div>");
			sb.append("<div class=\"float-right\">Created date: "+p.getDateCreated()+"</div>");
			sb.append("</div>");

			sb.append("<div class=\"card-body bg-light\">");
			sb.append("<p class=\"card-text\">"+p.getText()+"</p>");

			if(p.getChildren()!=null && p.getChildren().size()>0)
			{
				sb.append(renderPostList(p.getChildren(), returnUrl, user, root));
			}

			sb.append("</div>");

			sb.append("<div class=\"post-footer card-footer text-muted\">");
			sb.append("<span class=\"badge badge-success\">Votes Up: <span class=\"target-success\">"
			+p.getVotes().getUpVotes()+"</span></span>");
			sb.append("<span class=\"badge badge-danger\">Votes Down:  <span class=\"target-danger\">"
			+p.getVotes().getDownVotes()+"</span></span>");
			
			if(usr!=null)
			{
				sb.append("<div class=\"float-right\">");
				if(usr.getId()!=p.getAuthor().getId())
				{
					sb.append("<form action=\""+root+"/editVotes\" method=\"POST\" class=\"d-inline votes-form\">Голосовать:");
					sb.append("<input type=\"hidden\" name=\"postId\" value=\""+p.getId()+"\">");
					sb.append("<input type=\"hidden\" name=\"returnUrl\" value=\""+rUrl+"\">");
					sb.append("<button type=\"submit\" class=\"btn btn-primary\" name=\"action\" value=\"up\">+</button>");
					sb.append("<button type=\"submit\" class=\"btn btn-primary\" name=\"action\" value=\"down\">-</button>");
					sb.append("</form>");

					sb.append("<a href=\""+root+"/editPost?returnUrl="
						+rUrl+"&topicId="
						+p.getTopic().getId()+"&parentId="+
						p.getId()+"\" class=\"btn btn-primary\">Ответить</a>");

				}
				if(usr.getGroup().getName().equals("admins") || usr.getId()==p.getAuthor().getId())
				{
					sb.append("<form action=\""+root+"/editPost\" method=\"POST\" class=\"d-inline\">");
					sb.append("<input type=\"hidden\" name=\"postId\" value=\""+p.getId()+"\">");
					sb.append("<input type=\"hidden\" name=\"returnUrl\" value=\""+rUrl+"\">");
					sb.append("<button type=\"submit\" class=\"btn btn-danger\">Удалить</button>");
					sb.append("</form>");
				}
				sb.append("</div>");
			}
			sb.append("</div>");

			sb.append("</div>");
		}

		return new String(sb);
	}
%>