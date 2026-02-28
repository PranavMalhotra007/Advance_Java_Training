<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>

<h2>Update Employee</h2>

<form action="updateDone" method="post">

    <label>Id:</label>
    <input type="number" name="id" value="${employee.id}" readonly>
    <br><br>

    <label>Name:</label>
    <input type="text" name="name" value="${employee.name}">
    <br><br>

    <label>Phone:</label>
    <input type="text" name="phone" value="${employee.phone}">
    <br><br>

    <label>Email:</label>
    <input type="email" name="email" value="${employee.email}">
    <br><br>

    <input type="submit" value="Update">

</form>

<br>
<a href="displayAll?id=1">Back to List</a>

</body>
</html>