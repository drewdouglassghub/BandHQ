<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Musician</title>
</head>
<body>
<form action="EditMusicianServlet" method="post">
		First Name: <input type="text" name="firstName" value="${musicianToEdit.firstName}">
		Last Name: <input type="text" name="lastName" value="${musicianToEdit.lastName}">
		Instrument: <input type="text" name="instrument" value="${musicianToEdit.instrument}">
		<input type="hidden" name="id" value="${musicianToEdit.id}"> 
		<input type="submit" value="Save Edited Musician">
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>