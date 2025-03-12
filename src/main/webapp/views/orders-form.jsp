<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Form</title>

    <style>
            /* General Body Styles */
            body {
                font-family: 'Arial', sans-serif;
                background-color: #ffe5b4; /* Light yellowish background */
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                min-height: 100vh; /* Full viewport height */
                text-align: center;
            }

            /* Heading Styles */
            h2 {
                font-size: 2.5em;
                margin-bottom: 20px;
                color: #333;
            }

            /* Form Styling */
            form {
                background-color: white;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 600px;
                box-sizing: border-box;
                text-align: left;
            }

            /* Label and Input Styles */
            label {
                font-size: 1.1em;
                color: #333;
                margin-bottom: 5px;
                display: block;
            }

            input[type="text"], input[type="number"], select {
                width: 100%;
                padding: 10px;
                font-size: 1em;
                border: 1px solid #ddd;
                border-radius: 5px;
                margin-bottom: 15px;
                box-sizing: border-box;
            }

            /* Input focus effect */
            input[type="text"]:focus, input[type="number"]:focus, select:focus {
                border-color: #6c7ae0;
                outline: none;
            }

            /* Checkbox Styles */
            input[type="checkbox"] {
                margin-right: 10px;
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

            /* Action Buttons Styling */
            a {
                display: inline-block;
                padding: 10px 20px;
                margin-top: 20px;
                background-color: #D98586;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-size: 1em;
                transition: background-color 0.3s ease;
            }

            /* Hover effect for links */
            a:hover {
                background-color: #D98550;
            }

        </style>
</head>
<body>

    <form action="/submitOrder" method="post">
        <h1>Order Form</h1>

        <!-- Book Selection -->
        <label for="book">Select Book:</label>
        <select id="book" name="bookId" multiple required>
            <c:forEach var="book" items="${books}">
                <option value="${book.bookId}">${book.title} - $${book.price}</option>
            </c:forEach>
        </select>

         <!-- Customer Selection (Single Customer, dropdown is non-editable) -->
         <label for="customer">Customer:</label>
         <select id="customer" name="customerId" readonly>
             <option value="${customer.customerId}">${customer.customerName}</option>
         </select>


        <!-- Quantity Input -->
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required />

        <!-- Submit Button -->
        <input type="submit" value="Submit Order" />
    </form>

    <a href="/homepage">Back to Home</a>

</body>
</html>
