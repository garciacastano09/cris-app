<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRIS: Researchers List</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
</head>
<body>
<c:if test="${null != user}">
	<a href="LogoutServlet" class="btn btn-danger">Log out</a>
</c:if>

<h1>Researchers List</h1>
	<table class="table table-striped w-75 m-2">
		<thead class="">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Affiliation</th>
				<th>Email</th>
			</tr>
		</thead>
		<c:forEach items="${rs}" var="rsi">
			<tr>
				<td> <a href=<c:out value="ViewResearcherServlet?rsi=${rsi.id}"/>>
             		<c:out value="${rsi.id}" /></a></td>
				<td><c:out value="${rsi.name}"/></td>
				<td><c:out value="${rsi.affiliation}"/></td>
				<td><c:out value="${rsi.email}"/></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>