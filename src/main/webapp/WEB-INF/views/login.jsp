<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login | Dark Theme</title>

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
        <h3 class="text-center mb-4">Login</h3>

        <!-- Show error message if present -->
        <c:if test="${not empty errormsg}">
            <div class="alert alert-danger" role="alert">
                ${errormsg}
            </div>
        </c:if>

        <form action="login" method="post">
            <div class="mb-3">
                <label for="userName" class="form-label">Username</label>
                <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter username" required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>

        <div class="text-center mt-3">
            <a href="registerpage">Don't have an account? Register</a>
        </div>
        
        <div class= mt-3>
        	<a href="forgotpass">Forgot Password</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
