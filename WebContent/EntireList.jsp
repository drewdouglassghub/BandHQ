<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bands and Musicians</title>
</head>
<body>
<form action = "ViewAllServlet" method="post">

	<h3>Band: ${currentband.bandName}</h3>
	<c:forEach items="${requestScope.foundMembers}" var="currentmusician">
				<tr>
					<td><input type="radio" name="id" value="${currentmusician.musicianId}"></td>
					<td>${currentmusician.firstName}</td>
					<td>${currentmusician.lastName}</td>
					<td>${currentmusician.instrument}</td>
				</tr>
			</c:forEach>


</form>
	<a href="index.html">Home</a>
		
</body>
</html>