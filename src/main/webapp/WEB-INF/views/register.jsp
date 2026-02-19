<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>User Registration</h2>

	<form action="registerUser" method="post">

		Username : <input type="text" name="username" /><br>
		<br> Password : <input type="password" name="password" /><br>
		<br> Email : <input type="text" name="email" /><br>
		<br> Contact : <input type="text" name="contact" /><br>
		<br> <input type="submit" value="Register" />
	</form>

	<h3>${msg}</h3>
</body>
</html>