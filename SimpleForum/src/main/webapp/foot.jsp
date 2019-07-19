<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</div>
  <c:if test="${topic != null}">
  	<script src="votes-change.js"></script>
     <script>
     	setHandlers();
     </script>
  </c:if>
</body>
</html>