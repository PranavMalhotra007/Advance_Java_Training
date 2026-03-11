<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Customer Login</h2>

<form action="log" method="post">

    <label>Customer ID:</label>
    <input type="number" name="customer_ID" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>

</form>

<h3 style="color:red">${error}</h3>

<a href="register">New User? Register</a>

</body>
</html>