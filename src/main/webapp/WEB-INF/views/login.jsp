<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${not empty errormsg}">
   <div style="color: red;">${errormsg}</div>
</c:if>
	
    <form action="login" method="post">
    <input type="text" name="userName" placeholder="Username" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>
</form>

</body>
</html>