<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="error-page.jsp"%>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<main>
	<c:if test="${topicList==null || topicList.size()==0}">
		<h2>Unfortunately< this section is empty yet!</h2>
	</c:if>
	<c:if test="${topicList!=null && topicList.size()>0}">
		<c:forEach var="topic" items="${topicList}">
			<div class="card">
			  <div class="card-header text-light bg-dark clearfix">
			  	<div class="float-left">Author: ${topic.author.login}</div>
			  	<div class="float-right">Created date: ${topic.dateCreated}</div>
			  </div>
			  <div class="card-body bg-light">
			    <h4 class="card-title">${topic.title}</h5>
			  </div>
			  <div class="topic-footer card-footer text-muted">
				<div class="float-right">
				    <a href='<c:url value="/topics?id=${topic.id}" />' class="btn btn-primary">Перейти к обсуждению</a>
				    <c:if test='${sessionScope.user!=null && sessionScope.user.group.name.equals("admins")}'>
				    	<form class="d-inline" action='<c:url value="/editTopic" />' method="POST">
				    	<input type="hidden" name="topicId" value="${topic.id}">
				    		<button class="btn btn-danger" type="submit">Удалить</button>
				    	</form>
					</c:if>
				</div>
			  </div>
			</div>
		</c:forEach>
	</c:if>
</main>
<jsp:include page="foot.jsp" />
