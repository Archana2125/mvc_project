<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f6f6f6;
            margin: 0;
            padding: 20px;
        }

        form {
            background-color: white;
            max-width: 600px;
            margin: auto;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        fieldset {
            border: none;
            margin-bottom: 20px;
        }

        legend {
            font-size: 1.2em;
            margin-bottom: 10px;
            font-weight: bold;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-size: 1em;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<form action="registerUser" method="post">
    <fieldset>
        <legend>User Information</legend>

        <label for="first_name">First Name:</label>
<input type="text" id="first_name" name="user.firstName" placeholder="John" required>

<label for="middle_name">Middle Name:</label>
<input type="text" id="middle_name" name="user.middleName" placeholder="A.">

<label for="last_name">Last Name:</label>
<input type="text" id="last_name" name="user.lastName" placeholder="Doe" required>

<label for="email">Email:</label>
<input type="email" id="email" name="user.email" placeholder="john@example.com" required>

<label for="user_name">Username:</label>
<input type="text" id="user_name" name="user.userName" placeholder="johndoe123" required>

<label for="password">Password:</label>
<input type="password" id="password" name="user.password" required>

<label for="conformPassword">Confirm Password:</label>
<input type="password" id="conformPassword" name="user.conformPassword" required>

<label for="role">Role:</label>
<input type="text" id="role" name="user.role" placeholder="user/admin">

<label for="contactno">Contact No:</label>
<input type="text" id="contactno" name="user.contactNo" placeholder="1234567890" pattern="[0-9]{10}" required>
        
    <fieldset>
        <legend>Address Information</legend>

        <label for="house_name">House Name:</label>
        <input type="text" id="house_name" name="address.house_name" placeholder="Sunshine Villa" required>

        <label for="house_ho">House No:</label>
        <input type="number" id="house_ho" name="address.house_no" required>

        <label for="city">City:</label>
        <input type="text" id="city" name="address.city" placeholder="Mumbai" required>

        <label for="landmark">Landmark:</label>
        <input type="text" id="landmark" name="address.landmark" placeholder="Near Central Park">

        <label for="district">District:</label>
        <input type="text" id="district" name="address.district" required>

        <label for="pincode">Pincode:</label>
        <input type="text" id="pincode" name="address.pincode" pattern="[0-9]{6}" placeholder="400001" required>
    </fieldset>

    <button type="submit">Register</button>
</form>

</body>
</html>
