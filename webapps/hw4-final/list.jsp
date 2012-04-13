<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="databeans.BookmarkBean" %>
<p>
	<table>
    <c:if test="${!(empty bookmarkList)}">
        <c:forEach var="bookmark" items="${bookmarkList}">

        <tr>
            <td><a href="view.do?id=${bookmark.bookmarkId}">${bookmark.url}</a></td>
			<td>${bookmark.comment}</td>        
			<td>${bookmark.clickCount} clicks</td>
        </tr>
  
        </c:forEach>
         
    </c:if>
	</table>
</p>

<jsp:include page="template-bottom.jsp" />
