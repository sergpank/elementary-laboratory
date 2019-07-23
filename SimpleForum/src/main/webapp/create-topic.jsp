<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="error-page.jsp"%>
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
	<form method="POST" action="">
	  <div class="form-group">
	  	<input type="hidden" name="returnUrl" value="${returnUrl}">
	    <label for="example">Введите название новой темы:</label>
	    <textarea name="text" id="example"  class="form-control"></textarea>
	  </div>
	  <button class="btn btn-primary" type="submit">Submit form</button>
	  <a href="${returnUrl}" class="btn btn-secondary">Cancel</a>
	</form>
</main>
<jsp:include page="foot.jsp" />