<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        width: 400px;
    }

    h1.title {
        text-align: center;
        color: #333;
        font-size: 22px;
        margin-bottom: 25px;
    }

    .detail {
        margin-bottom: 15px;
        padding: 10px;
        border-radius: 5px;
        background-color: #f9fafc;
        border-left: 4px solid #4CAF50;
    }

    .label {
        font-weight: bold;
        color: #555;
    }

    .value {
        margin-left: 5px;
        color: #222;
    }

    .btn {
        display: block;
        text-align: center;
        margin-top: 20px;
        padding: 10px;
        background-color: #2196F3;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    .btn:hover {
        background-color: #1976D2;
    }
</style>

</head>
<body>

<div class="container">
    <h1 class="title">Student Details</h1>

    <div class="detail">
        <span class="label">Id:</span>
        <span class="value">${id}</span>
    </div>

    <div class="detail">
        <span class="label">Name:</span>
        <span class="value">${name}</span>
    </div>

    <div class="detail">
        <span class="label">Phone:</span>
        <span class="value">${phone}</span>
    </div>

    <div class="detail">
        <span class="label">Email:</span>
        <span class="value">${email}</span>
    </div>

    <a href="find" class="btn">Search Student</a>
</div>

</body>
</html>