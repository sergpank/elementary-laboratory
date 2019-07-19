<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
	request.setAttribute("title", "Error")
%>
<jsp:include page="head.jsp" />
	<main>
		<div class="alert alert-warning">
			<%
				out.println(exception.toString());
			%>
		</div>
	</main>
<jsp:include page="foot.jsp" />