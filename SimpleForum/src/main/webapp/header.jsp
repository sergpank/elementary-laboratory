<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.net.URLEncoder" %>
<header>
	<div class="top-header d-flex justify-content-between align-items-center bg-light">
		<c:if test="${sessionScope.user!=null}">
			<h6 class="user-name d-inline-flex">User: ${user.login}</h6>
			<div class="btn-group d-inline-flex">
			  <a href="#" class="btn btn-secondary">Change password</a>
			  <a href='<c:url value="/logout?returnUrl=${url}" />' class="btn btn-secondary">Logout</a>
			</div>
		</c:if>
		<c:if test="${sessionScope.user==null}">
			<h6 class="user-name d-inline-flex"></h6>
			<div class="btn-group d-inline-flex">
			  <a href='<c:url value="/login?returnUrl=${url}" />' class="btn btn-secondary">Login</a>
			  <a href='<c:url value="/register?returnUrl=${url}" />' class="btn btn-secondary">Register</a>
			</div>
		</c:if>
	</div>
	<h1 class="display-4 bg-light">Forum</h1>
	<nav>
		<ul class="nav bg-light">
		  <li class="nav-item">
		    <a class="nav-link active" href='<c:url value="/topics" />'>Topics</a>
		  </li>
		  <c:if test="${sessionScope.user!=null}">
			  <li class="nav-item">
			    <a class="nav-link" href='<c:url value="/editTopic?returnUrl=${url}" />'>Create topic</a>
			  </li>
			    <c:if test="${topic != null}">
			        <li class="nav-item">
			  	    <a class="nav-link" 
			  	    href='<c:url value="/editPost?topicId=${topic.id}&returnUrl=${url}" />'>
			  			Create post
			  		</a>
			  	  </li>
			    </c:if>
		  </c:if>
		</ul>
	</nav>
</header>