<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="AdminHeader.jsp" %>
</head>
<body>

<div class="container mt-5">
    <div class="card p-4">
        <h3 class="mb-4 text-center">Add New Product</h3>
        <c:if test="${not empty error}">
    <script>
        alert("${error}");
    </script>
</c:if>

        <form action="addProduct" method="post" enctype="multipart/form-data">
            
            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Product Name</label>
                    <input type="text" name="product_name" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Batch No</label>
                    <input type="text" name="batch_no" class="form-control" required>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea name="description" rows="3" class="form-control"></textarea>
            </div>

            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label">Price</label>
                    <input type="number" step="0.01" name="price" class="form-control" required>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Stock Quantity</label>
                    <input type="number" name="stock_quantity" class="form-control" required>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Product Image</label>
                    <input type="file" name="image" class="form-control" accept="image/*">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Category</label>
                    <select name="category_id" class="form-select" required>
                        <option value="">-- Select Category --</option>
                        <c:forEach var="cat" items="${categories}">
                            <option value="${cat.category_id}">${cat.category_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Brand</label>
                    <select name="brand_id" class="form-select" required>
                        <option value="">-- Select Brand --</option>
                        <c:forEach var="brand" items="${brands}">
                            <option value="${brand.brand_id}">${brand.brand_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row mb-4">
                <div class="col-md-6">
                    <label class="form-label">Manufacture Date</label>
                    <input type="date" name="manufactor_date" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Expire Date</label>
                   <input type="date" name="expire_date" class="form-control" required>
                </div>
            </div>

            <div class="text-end">
                <button type="submit" class="btn btn-success">Submit Product</button>
            </div>
        </form>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
