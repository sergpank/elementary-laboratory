<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			    <h5 class="card-title"><a href='<c:url value="/topics?id=${topic.id}" />'>${topic.title}</a></h5>
			  </div>
			</div>
		</c:forEach>
	</c:if>
</main>
<jsp:include page="foot.jsp" />
