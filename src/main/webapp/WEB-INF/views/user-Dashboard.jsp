<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<jsp:include page="userHeader.jsp" />
<style>
.products-grid {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
}
.product-card {
    border: 1px solid #ccc;
    padding: 10px;
    width: 200px;
}
</style>
</head>
<body>
    <h1>Welcome to User Dashboard</h1>
    
    <div class="products-grid">
        <c:forEach items="${products}" var="p">
            <div class="product-card">
                <c:if test="${not empty p.base64Image}">
                    <img src="data:image/jpeg;base64,${p.base64Image}" alt="${p.name}" width="150"/>
                </c:if>
                <p>${p.name}</p>
                <p>Price: ${p.price}</p>
            </div>
        </c:forEach>
    </div>
    
</body>
<%@ include file="footer.jsp" %>
</html>
