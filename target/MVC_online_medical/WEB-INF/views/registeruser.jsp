<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            background-color: #f6f6f6;
            padding: 20px;
        }
        .form-step {
            display: none;
        }
        .form-step.active {
            display: block;
        }
        form {
            background-color: white;
            max-width: 800px;
            margin: auto;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        button {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<form action="registerUser" method="post" id="multiStepForm">
    
    <!-- Step 1: User Info -->
    <div class="form-step active" id="step1">
        <h4>User Information</h4>
        <div class="row g-3">
            <div class="col-md-6">
                <label>First Name:</label>
                <input type="text" name="user.first_name" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>Middle Name:</label>
                <input type="text" name="user.middle_name" class="form-control">
            </div>
            <div class="col-md-6">
                <label>Last Name:</label>
                <input type="text" name="user.last_name" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>Email:</label>
                <input type="email" name="user.email" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>Username:</label>
                <input type="text" name="user.user_name" class="form-control" required>
            </div>
            
            <!-- Password and Confirm Password Side by Side -->
            <div class="col-md-6">
            	<c:if test="${not empty wrongpass}">
   				<div style="color: red;">${errormsg}</div>
				</c:if>
                <label>Password:</label>
                <input type="password" name="user.password" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>Confirm Password:</label>
                <input type="password" name="user.Conformpassword" class="form-control" required>
            </div>

            <!-- Role as Radio Buttons -->
            <div class="col-md-6">
                <label>Role:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="user.role" id="roleUser" value="user" required>
                    <label class="form-check-label" for="roleUser">User</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="user.role" id="roleAdmin" value="admin" required>
                    <label class="form-check-label" for="roleAdmin">Admin</label>
                </div>
            </div>

            <div class="col-md-6">
                <label>Contact No:</label>
                <input type="text" name="user.contactno" class="form-control" pattern="[0-9]{10}" required>
            </div>
        </div>
        <button type="button" class="btn btn-primary float-end" onclick="nextStep()">Next</button>
    </div>

    <!-- Step 2: Address Info -->
    <div class="form-step" id="step2">
        <h4>Address Information</h4>
        <div class="row g-3">
            <div class="col-md-6">
                <label>House Name:</label>
                <input type="text" name="address.house_name" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>House No:</label>
                <input type="number" name="address.house_no" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>City:</label>
                <input type="text" name="address.city" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>Landmark:</label>
                <input type="text" name="address.landmark" class="form-control">
            </div>
            <div class="col-md-6">
                <label>District:</label>
                <input type="text" name="address.district" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label>Pincode:</label>
                <input type="text" name="address.pincode" class="form-control" pattern="[0-9]{6}" required>
            </div>
        </div>
        <div class="d-flex justify-content-between mt-3">
            <button type="button" class="btn btn-secondary" onclick="prevStep()">Back</button>
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
    </div>
</form>

<script>
    function nextStep() {
        document.getElementById("step1").classList.remove("active");
        document.getElementById("step2").classList.add("active");
    }

    function prevStep() {
        document.getElementById("step2").classList.remove("active");
        document.getElementById("step1").classList.add("active");
    }
</script>

</body>
</html>
