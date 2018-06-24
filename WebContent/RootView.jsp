<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRIS: Root console</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
</head>
<body>
<c:if test="${null != user}">
	<a href="LogoutServlet" class="btn btn-danger">Log out</a>
</c:if>
<h1>Root console</h1>
<a href="ListResearchersServlet" class="btn btn-primary">List researchers</a>
<h2>Add researcher</h2>
	<form style="padding: 2cm" method="get" action="CreateResearcherServlet" class="w-50">
		<p>Id</p>
		<input type="text" class="form-control" name="id" placeholder="Id">
		<p>Name</p>
		<input type="text" class="form-control" name="name" placeholder="Name">
		<p>Affiliation</p>
		<input type="text" class="form-control" name="affiliation" placeholder="Affiliation">
		<p>Email</p>
		<input type="text" class="form-control" name="email" placeholder="Email">
		<p>Password</p>
		<input type="password" class="form-control" name="pwd" placeholder="Password">
		<button type="submit" class="btn btn-success">Create or update researcher</button>
	</form>
</body>
</html>