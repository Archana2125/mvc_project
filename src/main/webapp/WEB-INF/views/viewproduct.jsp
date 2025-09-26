<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products in Category</title>
<%@ include file="AdminHeader.jsp" %>
<style>
.products-grid {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
    margin-top: 20px;
}
.product-card {
    width: 200px;
    border: 1px solid #ddd;
    border-radius: 10px;
    padding: 10px;
    text-align: center;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}
.product-card img {
    width: 100%;
    height: 150px;
    object-fit: cover;
    border-radius: 5px;
    margin-bottom: 10px;
}
.product-card p {
    margin: 5px 0;
    font-weight: bold;
}
</style>
</head>
<body>

<h2 style="text-align:center;">Products in this Category</h2>

<div class="products-grid">
    <c:forEach items="${products}" var="p">
    <div class="product-card">
        <c:if test="${not empty p.base64Image}">
            <img src="${p.base64Image}" alt="${p.name}" />
        </c:if>
        <p>${p.name}</p>
        <p>Price: ${p.price}</p>
    </div>
</c:forEach>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>
