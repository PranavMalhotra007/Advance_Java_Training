<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

<h2>Customer Registration</h2>

<form action="reg" method="post">
    <label>Customer ID:</label>
    <input type="number" name="customer_ID" required><br><br>

    <label>Name:</label>
    <input type="text" name="name" required><br><br>

    <label>Email:</label>
    <input type="email" name="email" required><br><br>

    <label>Address:</label>
    <input type="text" name="address" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>

<a href="login">Already have account? Login</a>

</body>
</html>