<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MedStore - Online Medical Store</title>

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
        a.nav-link:hover, a.btn:hover {
            color: #ffffff !important;
        }
    </style>
</head>
<body>

<!-- DARK THEMED NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm sticky-top">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">
            <ion-icon name="medkit-outline" class="me-1"></ion-icon> MedicoStore
        </a>

        <!-- Mobile toggle button -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#"><ion-icon name="#"></ion-icon> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><ion-icon name="#"></ion-icon> About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><ion-icon name="#"></ion-icon> Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><ion-icon name="#"></ion-icon> Contact</a>
                </li>
            </ul>

            <!-- Login/Register buttons -->
            <div class="d-flex ms-lg-3">
                <a href="loginpage" class="btn btn-outline-light me-2">
                    <ion-icon name="log-in-outline"></ion-icon> Login
                </a>
                <a href="registerpage" class="btn btn-dark text-dark">
                    <ion-icon name="person-add-outline"></ion-icon> Register
                </a>
            </div>
        </div>
    </div>
</nav>

<!-- Page content goes here -->

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
