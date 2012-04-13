<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p style="font-size:medium">
	Add a new bookmark:
</p>

<jsp:include page="error-list.jsp" />

<p>
	<form method="post" action="addbm.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td> URL: </td>
				<td><input type="text" name="url" value="${form.url}"/></td>
			</tr>
			<tr>
				<td>Comment: </td>
				<td><input type="text" name="comment" value="${form.comment}"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="button" value="Add"/>
				</td>
			</tr>
		</table>
	</form>
</p>
<hr/>
<%@ page import="databeans.BookmarkBean" %>
<p>
	<table>
		<c:forEach var="bookmark" items="${bookmarkList}">
			<tr>
				<td valign="top">
					<form method="POST" action="remove.do">
						<input type="hidden" name="id" value="${bookmark.bookmarkId}"/>
						<input type="submit" value="X"/>
					</form>
				</td>
				
				<td valign="top"><a href="${bookmark.url}">${bookmark.url}</a></td>
				<td valign="top">${bookmark.comment}</td>
				<td valign="top">${bookmark.clickCount} clicks</td>
			</tr>
		</c:forEach>
	</table>
</p>

<jsp:include page="template-bottom.jsp" />
