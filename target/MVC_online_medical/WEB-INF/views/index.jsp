
<html>
<head>
    <title>Landing Page</title>
    <%@ include file="hedder.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>

<body>
    <center><h1>Welcome to the Online Medical Store</h1></center>
   
   <!-- CATEGORY SECTION -->
<section class="py-5 bg-dark text-light">
    <div class="container">
        <h2 class="text-center mb-5">Shop by Category</h2>
        <div class="row justify-content-center text-center">

            <!-- Category Card -->
            <div class="col-6 col-sm-4 col-md-2 mb-4">
                <div class="bg-light rounded shadow-sm p-3">
                    <img src="fitness.jpg" alt="Fitness" class="img-fluid rounded mb-2" style="height: 100px; object-fit: contain;">
                    <p class="mb-0 text-dark fw-semibold">Fitness</p>
                </div>
            </div>

            <div class="col-6 col-sm-4 col-md-2 mb-4">
                <div class="bg-light rounded shadow-sm p-3">
                    <img src="personalcare.jpg" alt="Personal Care" class="img-fluid rounded mb-2" style="height: 100px; object-fit: contain;">
                    <p class="mb-0 text-dark fw-semibold">Personal Care</p>
                </div>
            </div>

            <!-- <div class="col-6 col-sm-4 col-md-2 mb-4">
                
            </div> -->

            <!-- <div class="col-6 col-sm-4 col-md-2 mb-4">
                
            </div> -->

            <div class="col-6 col-sm-4 col-md-2 mb-4">
                <div class="bg-light rounded shadow-sm p-3">
                    <img src="vitamins.jpg" alt="Vitamins" class="img-fluid rounded mb-2" style="height: 100px; object-fit: contain;">
                    <p class="mb-0 text-dark fw-semibold">Vitamins</p>
                </div>
            </div>

            <div class="col-6 col-sm-4 col-md-2 mb-4">
                <div class="bg-light rounded shadow-sm p-3">
                    <img src="makeup.jpg" alt="Make-up" class="img-fluid rounded mb-2" style="height: 100px; object-fit: contain;">
                    <p class="mb-0 text-dark fw-semibold">Make-up</p>
                </div>
            </div>

        </div>
    </div>
</section>
   
   
</body>
<%@ include file="footer.jsp" %>
</html>