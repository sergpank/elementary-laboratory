<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page errorPage="error-page.jsp"%>
<% request.setAttribute("title","Home"); %>
<jsp:include page="head.jsp" />
	<main>
		<div class="jumbotron">
		  <h1 class="display-4">Добро пожаловать на наш форум</h1>
		  <p class="lead">
		  	Здесь Вы можете участвовать в обсуждении существующих тем а также создавать новые.
		  	Однако, для этого Вам нужно будет зарегистрироваться. 
		  </p>
		  <hr class="my-4">	  
		  <a class="btn btn-primary btn-lg" href='<c:url value="/topics" />' role="button">Перейти к темам</a>
		</div>
	</main>
<jsp:include page="foot.jsp" />
