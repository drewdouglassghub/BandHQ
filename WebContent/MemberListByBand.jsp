<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Band:
	<input name="bandName" value="${bandName.getBandName()}">
	<table>
		<c:forEach var="member" items="${bandMembers}">
			<tr>
				<td></td>
				<td colspan="3">${member.firstName} ${member.lastName} ${member.instrument}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.html">Home</a>
</body>
</html>