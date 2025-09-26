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
    justify-content: flex-start;
}

.product-card {
    border: 1px solid #ccc;
    padding: 15px;
    width: 220px;
    box-shadow: 0px 2px 5px rgba(0,0,0,0.1);
    border-radius: 8px;
    background: #fff;
    text-align: center;
}

.product-card img {
    max-width: 100%;
    height: 180px;     /* fixed height so images don’t stretch unevenly */
    object-fit: contain; /* keep aspect ratio */
    margin-bottom: 10px;
    border-radius: 5px;
}
.product-card button {
    background-color: #28a745;
    color: white;
    border: none;
    padding: 8px 12px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 14px;
    transition: background 0.3s;
}

.product-card button:hover {
    background-color: #218838;
}
</style>
</head>
<body>
    <h1>Welcome to User Dashboard</h1>
    
    <div class="products-grid">
        <c:forEach items="${products}" var="p">
            <div class="product-card">
                <c:if test="${not empty p.base64Image}">
                    <img src="${p.base64Image}" alt="${p.name}" />
                </c:if>
                <p><strong>${p.name}</strong></p>
                <p>Price: ${p.price}</p>
                
                
                <!-- Add to Cart Button -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="${p.id}" />
                    <button type="submit">Add to Cart</button>
                </form>
            </div>
        </c:forEach>
    </div>
    
</body>
<%@ include file="footer.jsp" %>
</html>
