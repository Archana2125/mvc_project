<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login">
		<label for="user_name">Username:</label>
		<input type="text" id="user_name" name="user.user_name" placeholder="johndoe123" required>

		<label for="password">Password:</label>
		<input type="password" id="password" name="user.password" required>
		
		<button type="submit">Login</button>
	</form>
</body>
</html>