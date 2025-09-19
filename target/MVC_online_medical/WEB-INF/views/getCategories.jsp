<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <%@ include file="AdminHeader.jsp" %>
</head>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7;
}

h2 {
    text-align: center;
    margin-top: 30px;
    font-size: 28px;
    color: #333;
}

.category-grid {
    display: flex;
    justify-content: center; /* Center the grid itself */
    gap: 20px;
    flex-wrap: wrap;
    padding: 20px;
}

.category-card {
    width: 150px;
    padding: 10px;
    background-color: #ffeef6;
    text-align: center;
    border-radius: 10px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    transition: transform 0.2s;
}

.category-card:hover {
    transform: scale(1.05);
}

.category-img {
    width: 100%;
    height: 100px;
    object-fit: cover;
    border-radius: 10px;
    margin-bottom: 10px;
}

.category-card p {
    font-weight: bold;
    color: #444;
    margin: 0;
}
</style>
<body>
		<h2>Categories</h2>

<div class="category-grid">
    <c:forEach var="cat" items="${categories}">
        <div class="category-card">
        <a href="products/${cat.id}">
            <img src="${cat.base64Image}" alt="${cat.name}" class="category-img"/>
        </a>
           <p>${cat.name}</p>
        </div>
    </c:forEach>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>