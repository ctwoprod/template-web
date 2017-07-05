<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Form Page Simple</title>
</head>
<body>

	<form action="FormServlet" method="post">
		Field1: <input type="text" name="user"> <br> Field2:
		<input type="password" name="pwd"> 
		 <input type="hidden"
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		<br><br> <input type="submit" value="Login" id="btnSubmit">
	</form>
</body>
</html>