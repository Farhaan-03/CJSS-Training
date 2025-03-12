<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Book</title>

    <style>
        /* General Body Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #ffe5b4; /* Light yellowish background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full viewport height */
            text-align: center;
            flex-direction: column; /* Ensure elements stack vertically */
        }

        /* Form Container */
        .form-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px; /* Max width of form container */
            box-sizing: border-box;
            margin-bottom: 20px; /* Space between form and book details */
        }

        /* Heading Style */
        h1 {
            color: #333;
            margin-bottom: 20px;
            font-size: 2em;
        }

        /* Label Styling */
        label {
            font-size: 1.1em;
            color: #333;
            margin-bottom: 5px;
            display: block;
        }

        /* Input and Select Styles */
        select, input[type="number"], input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        /* Input focus effect */
        select:focus, input[type="number"]:focus, input[type="text"]:focus {
            border-color: #6c7ae0;
            outline: none;
        }

        /* Submit Button Style */
        input[type="submit"] {
            background-color: #6c7ae0;
            color: white;
            padding: 10px 20px;
            font-size: 1.2em;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        /* Submit Button Hover Effect */
        input[type="submit"]:hover {
            background-color: #5a65d1;
        }

        /* Back Link Style */
        a {
            display: inline-block;
            margin-top: 20px;
            text-align: center;
            color: #333;
            text-decoration: none;
            font-size: 1.1em;
            padding: 10px 20px;
            background-color: #D98586;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        /* Hover effect for back link */
        a:hover {
            background-color: #D98550;
        }

        .book-details {
            margin-top: 20px;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px; /* Same width as form container */
            width: 100%;
            box-sizing: border-box;
        }

        .error-message {
            color: #ff0000;
            font-size: 1.2em;
            margin-top: 20px;
        }

    </style>
</head>
<body>

    <!-- Form to input Book ID -->
    <div class="form-container">
        <h1>Search Book</h1>
        <form action="/search" method="get">
            <label for="bookId">Enter Book ID:</label>
            <input type="number" id="bookId" name="bookId" required/>
            <input type="submit" value="Search" />
        </form>
    </div>


    <div class="error-message">
                ${exception}
            </div>

    <!-- Display Book Information -->
    <c:if test="${not empty book}">
        <div class="book-details">
            <h2>Book Details</h2>
            <div><strong>Book ID:</strong> ${book.bookId}</div>
            <div><strong>Title:</strong> ${book.title}</div>
            <div><strong>Author:</strong> ${book.author}</div>
            <div><strong>Price:</strong> $${book.price}</div>
            <div><strong>Stock:</strong> ${book.stock}</div>
        </div>
    </c:if>

    <!-- Back to Home Link -->
    <a href="/admin">Back to Home</a>

</body>
</html>
