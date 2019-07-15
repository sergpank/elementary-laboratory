<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	  <div class="form-group row">
	    <label for="colFormLabelSm" class="col-sm-4 col-form-label">Your Login:</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="colFormLabelSm" 
	      placeholder="your login" name="login" value="${user.login}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="colFormLabel" class="col-sm-4 col-form-label">Your Password:</label>
	    <div class="col-sm-8">
	      <input type="password" class="form-control" id="colFormLabel" name="password">
	    </div>
	  </div>
	  <button class="btn btn-primary" type="submit">Submit form</button>
	  <a href='<c:url value="/topics" />' class="btn btn-secondary">Cancel</a>
	</form>
</main>
<jsp:include page="foot.jsp" />