<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Topic</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<jsp:include page="top-header.jsp" />
		<jsp:include page="header.jsp" />
		<main>
			<c:if test="${topic == null}">
			    <h2>The post was not found</h2>
			</c:if>
			<c:if test="${topic != null}">
				<h2>${topic.title}</h2>
				 <p>Author of topic: ${topic.author.login}; Created: ${topic.dateCreated}</p>
				 <h3>Posts:</h3>
				<ul>
					<c:forEach var="post" items="${topic.posts}">
				        <li>
				        	<h4>Author: ${post.author.login}; Created: ${post.dateCreated}</h4>
				          	<p>${post.text}</p>
				          	<p>
				          		<span class="inline">Votes Up: <c:out value="${post.votes.upVotes}" default="0" />;</span>
				          		<span class="inline">Votes Down: <c:out value="${post.votes.downVotes}" default="0" /></span>
				          	</p>
				       	</li>
			      	</c:forEach>
				</ul>
			</c:if>
		</main>
	</div>	
</body>
</html>