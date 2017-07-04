<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Login Page using google recaptcha</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>

	<form action="LoginServlet" method="post">
		Username: <input type="text" name="user"> <br> Password:
		<input type="password" name="pwd"> <br>
		<div class="g-recaptcha" data-callback="enableBtn"
			data-sitekey="6LcZ6CcUAAAAAAHBR5_WKO4R2m62yIbbeDYxtjGc"></div>
		<br> <input type="submit" value="Login" disabled id="btnLogin">
	</form>
</body>
<script type="text/javascript">
	function enableBtn() {
		document.getElementById("btnLogin").disabled = false;
	}
</script>
</html>