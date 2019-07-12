<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Topics</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<jsp:include page="top-header.jsp" />
		<jsp:include page="header.jsp" />
		<main>
			<c:if test="${topicList==null || topicList.size() == 0}">
			    <h2>Unfortunately< this section is empty yet!</h2>
			</c:if>
			<c:if test="${topicList!=null && topicList.size() > 0}">
				<ul>
					<c:forEach var="topic" items="${topicList}">
            <li>
              <h4><a href='<c:url value="/topic" />?id=${topic.id}'>${topic.title}</a></h4>
              <p>Author: ${topic.author.login}; Created: ${topic.dateCreated}</p>
            </li>
			     </c:forEach>
				</ul>
			</c:if>
		</main>
	</div>	
</body>
</html>