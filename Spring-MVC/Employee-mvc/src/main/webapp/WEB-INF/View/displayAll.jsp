<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
</head>
<body>

<h2>Employee List</h2>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.phone}</td>
            <td>${emp.email}</td>

            <td>
                <form action="update" method="get">
                    <input type="hidden" name="id" value="${emp.id}">
                    <input type="submit" value="Update">
                </form>
            </td>

            <td>
                <form action="delete" method="post">
                   	<input type="hidden" name="id" value="${emp.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<br>
<a href="register">Add New Employee</a>

</body>
</html>