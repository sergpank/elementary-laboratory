<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<main>
	<c:if test="${topic == null}">
	    <h2>The topic was not found</h2>
	</c:if>
	<c:if test="${topic != null}">
		<h2>${topic.title}</h2>
		 <p>Author of topic: ${topic.author.login}; Created: ${topic.dateCreated}</p>
		 <h3>Posts:</h3>
		<c:forEach var="post" items="${topic.posts}">
			<div class="card">
			  <div class="card-header text-light bg-dark clearfix">
			  	<div class="float-left">Author: ${post.author.login}</div>
			  	<div class="float-right">Created date: ${post.dateCreated}</div>
			  </div>
			  <div class="card-body bg-light">
			    <p class="card-text">${post.text}</p>
			  </div>
			  <div class="card-footer text-muted">
			      <span class="d-inline">Votes Up: <c:out value="${post.votes.upVotes}" default="0" />;</span>
			      <span class="d-inline">Votes Down: <c:out value="${post.votes.downVotes}" default="0" /></span>
			  </div>
			</div>
      	</c:forEach>
	</c:if>
</main>
<jsp:include page="foot.jsp" />