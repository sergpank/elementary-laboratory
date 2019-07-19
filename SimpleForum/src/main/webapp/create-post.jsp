<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<main>
	<c:if test="${errors!=null}">
		<div class="alert alert-danger" role="alert">
			<ul>
				<c:forEach var="message" items="${errors}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<form method="POST" action="" accept-charset="UTF-8">
	  <div class="form-group">
	  	<input type="hidden" name="topicId" value="${topicId}">
	  	<input type="hidden" name="authorId" value="${sessionScope.user.id}">
	    <input type="hidden" name="returnUrl" value="${url}">
	    <c:if test="${parentId!=null}">
	    	<input type="hidden" name="parentId" value="${parentId}">
		</c:if>
	    <label for="example">Type your message here:</label>
	    <textarea name="text" id="example"  class="form-control"></textarea>
	  </div>
	  <button class="btn btn-primary" type="submit">Submit form</button>
	  <a href="${returnUrl}" class="btn btn-secondary">Cancel</a>
	</form>
</main>
<jsp:include page="foot.jsp" />