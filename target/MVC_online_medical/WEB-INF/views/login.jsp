<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
	<c:if test="${not empty errormsg}">
   <div style="color: red;">${errormsg}</div>
</c:if>
	
    <label for="user_name">Username:</label>
    <input type="text" name="userName" required />

    <label for="password">Password:</label>
    <input type="password" name="password" required />

    <label for="role">Role:</label>
    <select name="role">
        <option value="user">User</option>
        <option value="admin">Admin</option>
    </select>

    <button type="submit">Login</button>
</form>

</body>
</html>