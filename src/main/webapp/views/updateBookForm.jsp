<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffe5b4;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .form-container {
            background-color: white;
            padding: 30px;
            margin: 50px auto;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            box-sizing: border-box;
        }
        h1 {
            margin-bottom: 15px;
        }
        label {
            font-size: 1.2em;
            margin-bottom: 8px;
            display: block;
        }
        input[type="text"], input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            font-size: 1em;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h1>Update Book</h1>

    <!-- Using form:form from Spring MVC -->
    <form:form action="/update-book/${book.bookId}" method="post" modelAttribute="book">

        <!-- Book Id (disabled field) -->
        <form:label path="bookId">Book Id</form:label>
        <form:input path="bookId" id="bookId" disabled="true" />
        <form:errors path="bookId" class="error" />

        <!-- Title -->
        <form:label path="title">Title</form:label>
        <form:input path="title" id="title" />
        <form:errors path="title" class="error" />

        <!-- Author -->
        <form:label path="author">Author</form:label>
        <form:input path="author" id="author" />
        <form:errors path="author" class="error" />

        <!-- Price -->
        <form:label path="price">Price</form:label>
        <form:input path="price" id="price" />
        <form:errors path="price" class="error" />

        <!-- Stock -->
        <form:label path="stock">Stock</form:label>
        <form:input path="stock" id="stock" />
        <form:errors path="stock" class="error" />

        <input type="submit" value="Update Book" />
    </form:form>
</div>

<a href="/books">Back to Books</a>

</body>
</html>
