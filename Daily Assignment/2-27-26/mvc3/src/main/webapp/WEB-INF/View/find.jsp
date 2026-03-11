<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Student</title>

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
        width: 350px;
        text-align: center;
    }

    h1 {
        color: #333;
        font-size: 20px;
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: bold;
        color: #555;
        text-align: left;
    }

    input[type="number"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border-radius: 4px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-top: 20px;
        background-color: #2196F3;
        border: none;
        border-radius: 4px;
        color: white;
        font-size: 14px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #1976D2;
    }
</style>

</head>
<body>

<div class="container">
    <h1>Search Student</h1>

    <form action="displayById" method="get">
        <label>Student Id:</label>
        <input type="number" name="id" required>

        <input type="submit" value="Find">
    </form>
</div>

</body>
</html>