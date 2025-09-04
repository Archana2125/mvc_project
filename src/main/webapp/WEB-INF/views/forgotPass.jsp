<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #121212;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
        }

        .login-card {
            background-color: #1e1e1e;
            width: 100%;
            max-width: 400px;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(255, 255, 255, 0.05);
        }

        .form-control {
            background-color: #2c2c2c;
            border: 1px solid #444;
            color: #fff;
        }

        .form-control:focus {
            background-color: #2c2c2c;
            color: #fff;
            border-color: #0d6efd;
            box-shadow: none;
        }

        .btn-primary {
            background-color: #0d6efd;
            border: none;
        }

        .btn-primary:hover {
            background-color: #0b5ed7;
        }

        a {
            color: #0d6efd;
        }

        a:hover {
            color: #0a58ca;
            text-decoration: underline;
        }

        .alert-danger {
            background-color: #661c23;
            border: 1px solid #a94442;
            color: #f8d7da;
        }
    </style>
</head>
<body>

<div class="login-card">
    <h3 class="text-center mb-4">Forgot Password</h3>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    <c:if test="${not empty success}">
    <div class="alert alert-success" role="alert">
        ${success}
    </div>
</c:if>



    <form action="forgot" method="post">
        <div class="mb-3">
            <label>Username:</label>
            <input type="text" name="userName" class="form-control" required>
        </div>

        <div class="mb-3">
            <label>New Password:</label>
            <input type="password" name="password" class="form-control" placeholder="Enter new password" required>
        </div>

        <div class="mb-3">
            <label>Confirm Password:</label>
            <input type="password" name="confirmPassword" class="form-control" placeholder="Confirm password" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Set Password</button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
