<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRIS: Researcher view</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
</head>
<body>
<c:if test="${null != user}">
	<a href="LogoutServlet" class="btn btn-danger">Log out</a>
</c:if>
<h1>Researcher profile</h1>

	<h3>Id:</h3>
	<p>
		<c:out value="${researcher.id}"></c:out>
	</p>
	<h3>Name:</h3>
	<p>
		<c:out value="${researcher.name}"></c:out>
	</p>
	<h3>Affiliation:</h3>
	<p>
		<c:out value="${researcher.affiliation}"></c:out>
	</p>
	<h3>Email:</h3>
	<p>
		<c:out value="${researcher.email}"></c:out>
	</p>
	<h3>Publications:</h3>
	<table class="table table-striped w-75 m-2">
		<thead class="">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>CiteCount</th>
				<th>Authors</th>
			</tr>
		</thead>
		<c:forEach items="${researcher.pubs}" var="pubi">
			<tr>
				<td>
				<a href=<c:out value="UpdateCitationsServlet?pubid=${pubi.id}&rsi=${researcher.id}"></c:out>>
				<c:out value="${pubi.id}"></c:out></a>
				</td>
				<td><c:out value="${pubi.title}"></c:out></td>
				<td><c:out value="${pubi.citeCount}"></c:out></td>
				<td>
				<c:forEach items="${pubi.authors}" var="authi">
					<p><c:out value="${authi.name}"></c:out></p>
				</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="GenerateCVPdfServlet" class="btn btn-principal">Generate CV</a>
	<c:if test="${user.id==researcher.id or user.name =='root'}">
		<p>You have permission to edit this researcher profile</p>
		
		<a href=<c:out value="GetExternalPublicationsServlet?rsi=${researcher.id}"></c:out> class="btn btn-primary">List researchers</a>
		
		<h2>Update profile</h2>
		<form style="padding: 2cm" method="get" action="UpdateResearcherServlet" class="w-50">
		<input type="hidden"name="id" value=<c:out value="${researcher.id}"></c:out>>
		<p>Name</p>
		<input type="text" class="form-control" name="name" placeholder='<c:out value="${researcher.name}"></c:out>'>
		<p>Affiliation</p>
		<input type="text" class="form-control" name="affiliation" placeholder='<c:out value="${researcher.affiliation}"></c:out>'>
		<p>Email</p>
		<input type="text" class="form-control" name="email" placeholder='<c:out value="${researcher.email}"></c:out>'>
		<p>Password</p>
		<input type="password" class="form-control" name="pwd" placeholder="Password">
		<button type="submit" class="btn btn-success">Update profile</button>
		</form>
		
		<h2>Update profile</h2>
		<form style="padding: 2cm" method="get" action="CreatePublicationServlet" class="w-50">
		<input type="hidden"name="authId" value=<c:out value="${researcher.id}"></c:out>>
		<p>Id</p>
		<input type="text" class="form-control" name="id" placeholder="Publication Id">
		<p>Title</p>
		<input type="text" class="form-control" name="title" placeholder="Title">
		<p>Cite count</p>
		<input type="text" class="form-control" name="citecount" placeholder="Cite count">
		<button type="submit" class="btn btn-success">Add publication</button>
		</form>
	</c:if>

</body>
</html>