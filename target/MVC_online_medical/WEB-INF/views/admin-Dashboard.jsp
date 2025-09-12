
<html>
<head>
    <title>Landing Page</title>
    <%@ include file="AdminHeader.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>

<body>
   
   
<!-- Main content area -->
<div class="container mt-5">
    <h2 class="text-center">Admin Dashboard</h2>
    
</div>
   
 	 <%-- <c:if test="${not empty addc}">
    <script>
        alert("${addc}");
    </script>
</c:if> --%>
 	<c:if test="${not empty addbrand}">
    <div class="alert alert-success">${addbrand}</div>
</c:if>
   
</body>
<%@ include file="footer.jsp" %>
</html>