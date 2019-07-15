<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<header>
		<div class="top-header clearfix bg-light">
			<c:if test="${sessionScope.user!=null}">
				<h6 class="user-name d-inline">User: ${user.login}</h6>
				<div class="btn-group float-right">
				  <a href="#" class="btn btn-secondary">Change password</a>
				  <a href='<c:url value="/logout" />' class="btn btn-secondary">Logout</a>
				</div>
			</c:if>
			<c:if test="${sessionScope.user==null}">
				<div class="btn-group float-right">
				  <a href='<c:url value="/login" />' class="btn btn-secondary">Login</a>
				  <a href='<c:url value="/register" />' class="btn btn-secondary">Register</a>
				</div>
			</c:if>
		</div>
		<h1 class="text-light bg-dark">Forum</h1>
		<ul class="nav bg-light">
		  <li class="nav-item">
		    <a class="nav-link active" href='<c:url value="/topics" />'>Topics</a>
		  </li>
		  <c:if test="${sessionScope.user!=null}">
			  <li class="nav-item">
			    <a class="nav-link" href="#">Create topic</a>
			  </li>
		  </c:if>
		</ul>
	</header>
</header>