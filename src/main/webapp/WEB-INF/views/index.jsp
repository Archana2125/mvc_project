<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Landing Page</title>
    <%@ include file="hedder.jsp" %>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
          rel="stylesheet" 
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
          crossorigin="anonymous">

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
            crossorigin="anonymous"></script>

    <!-- Ionicons -->
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

    <style>
        .product-card {
            border: 1px solid #dee2e6;
            border-radius: 10px;
            padding: 15px;
            text-align: center;
            background: #fff;
            transition: transform 0.2s;
        }
        .product-card:hover {
            transform: translateY(-5px);
            box-shadow: 0px 4px 12px rgba(0,0,0,0.1);
        }
        .product-card img {
            max-width: 100%;
            height: 180px;
            object-fit: contain;
            margin-bottom: 10px;
        }
        .btn-cart {
            background-color: #28a745;
            color: white;
            border-radius: 5px;
            padding: 8px 12px;
            border: none;
            transition: background 0.3s;
        }
        .btn-cart:hover {
            background-color: #218838;
        }
    </style>
</head>

<body class="bg-light">
    <div class="container my-4">
        <h1 class="text-center mb-4">Welcome to the Online Medical Store</h1>

        <div class="row g-4">
            <c:forEach items="${products}" var="p">
                <div class="col-md-3 col-sm-6">
                    <div class="product-card h-100">
                        <c:if test="${not empty p.base64Image}">
                            <img src="${p.base64Image}" alt="${p.name}" />
                        </c:if>
                        <h5 class="mt-2">${p.name}</h5>
                        <p class="text-muted">Price: ${p.price}</p>

                        <!-- Add to Cart Button -->
                        <form action="addToCart" method="post">
                            <input type="hidden" name="productId" value="${p.id}" />
                            <button type="submit" class="btn-cart">
                                <ion-icon name="cart-outline"></ion-icon> Add to Cart
                            </button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
