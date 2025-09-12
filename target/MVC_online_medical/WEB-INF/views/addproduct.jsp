<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <%@ include file="AdminHeader.jsp" %>
    <title>Add New Product</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Optional Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }

        .card {
            border-radius: 10px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.05);
        }

        .form-label {
            font-weight: 500;
        }

        .container {
            max-width: 800px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="card p-4">
        <h3 class="mb-4 text-center"><i class="bi bi-plus-circle"></i> Add New Product</h3>

        <form action="addProduct" method="post" enctype="multipart/form-data">
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="product_name" class="form-label">Product Name</label>
                    <input type="text" name="product_name" id="product_name" class="form-control" required>
                </div>

                <div class="col-md-6">
                    <label for="batch_no" class="form-label">Batch No</label>
                    <input type="text" name="batch_no" id="batch_no" class="form-control" required>
                </div>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea name="description" id="description" rows="3" class="form-control" placeholder="Write a short description..."></textarea>
            </div>

            <div class="row mb-3">
                <div class="col-md-4">
                    <label for="price" class="form-label">Price</label>
                    <input type="number" step="0.01" name="price" id="price" class="form-control" required>
                </div>

                <div class="col-md-4">
                    <label for="stock_quantity" class="form-label">Stock Quantity</label>
                    <input type="number" name="stock_quantity" id="stock_quantity" class="form-control" required>
                </div>

                <div class="col-md-4">
                    <label for="image" class="form-label">Product Image</label>
                    <input type="file" name="image" id="image" class="form-control" accept="image/*">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="category_id" class="form-label">Category</label>
                    <select name="category_id" id="category_id" class="form-select" required>
                        <option value="">-- Select Category --</option>
                        <c:forEach var="cat" items="${categories}">
                            <option value="${cat.category_id}">${cat.category_name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-md-6">
                    <label for="brand_id" class="form-label">Brand</label>
                    <select name="brand_id" id="brand_id" class="form-select" required>
                        <option value="">-- Select Brand --</option>
                        <c:forEach var="brand" items="${brands}">
                            <option value="${brand.brand_id}">${brand.brand_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row mb-4">
                <div class="col-md-6">
                    <label for="manufactor_date" class="form-label">Manufacture Date</label>
                    <input type="date" name="manufactor_date" id="manufactor_date" class="form-control" required>
                </div>

                <div class="col-md-6">
                    <label for="expire_date" class="form-label">Expire Date</label>
                    <input type="date" name="expire_date" id="expire_date" class="form-control" required>
                </div>
            </div>

            <div class="text-end">
                <button type="submit" class="btn btn-success">
                    <i class="bi bi-check-circle"></i> Submit Product
                </button>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS (optional if using JS components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>
