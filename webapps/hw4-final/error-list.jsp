<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${!(empty errors)}">
	<p style="font-size:medium; color:red">
		<c:forEach var="error" items="${errors}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			${error}
			<br/>
		</c:forEach>
	</p>
</c:if>
