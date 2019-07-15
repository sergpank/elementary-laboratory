<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<main>
	<div class="alert alert-success" role="alert">
	  <h2>
	  	You have successfully registered on our site! You can now log in.
	  </h2> 
	  <a href='<c:url value="/login" />' class="btn btn-primary">Log in</a>
	</div>
</main>
<jsp:include page="foot.jsp" />