<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Simulate session (REMOVE THIS LINE IN PRODUCTION)
    if (session.getAttribute("adminName") == null) {
        session.setAttribute("adminName", "AdminUser");
    }

    // Declare only once
    String adminName = (String) session.getAttribute("adminName");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MedicoStore Admin Dashboard</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">

    <!-- Ionicons -->
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

    <style>
        body {
            background-color: #121212;
            color: #f0f0f0;
        }
        a.nav-link, a.navbar-brand, a.btn {
            color: #f0f0f0 !important;
        }
        a.nav-link:hover, .btn:hover {
            color: #ffffff !important;
        }
        .navbar .welcome-msg {
            color: #f0f0f0;
            font-weight: 500;
            margin-right: 15px;
        }
    </style>
</head>
<body>

<!-- DARK THEMED NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm sticky-top">
    <div class="container">
        <!-- Brand -->
        <a class="navbar-brand fw-bold" href="adminpage">
            <ion-icon name="medkit-outline" class="me-1"></ion-icon> MedicoStore Admin
        </a>

        <!-- Toggle for mobile view -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAdmin">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
        <div class="collapse navbar-collapse" id="navbarNavAdmin">
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="adminpage"><ion-icon name="home-outline"></ion-icon> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="productpage"><ion-icon name="add-circle-outline"></ion-icon> Add Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="manageProducts.jsp"><ion-icon name="construct-outline"></ion-icon> Manage Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addcategory"><ion-icon name="pricetags-outline"></ion-icon> Add Categories</a>
                </li>
                
                 <li class="nav-item">
                    <a class="nav-link" href="brand"><ion-icon name="pricetags-outline"></ion-icon> Add Brand</a>
                </li>
            </ul>

            <!-- Right side: welcome message and login/logout -->
            <div class="d-flex align-items-center">
                <% if (adminName != null) { %> <span class="welcome-msg me-2"> Welcome, <%= adminName %>
                    </span>
                    <a href="logout" class="btn btn-outline-light btn-sm">
                        <ion-icon name="log-out-outline"></ion-icon> Logout
                    </a>
                <% } else { %>
                    <a href="loginpage" class="btn btn-outline-light btn-sm">
                        <ion-icon name="log-in-outline"></ion-icon> Login
                    </a>
                <% } %>
            </div>
        </div>
    </div>
</nav>



<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
