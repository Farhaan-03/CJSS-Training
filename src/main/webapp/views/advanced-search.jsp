<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Advanced Search - Bookstore</title>
    <style>
        /* Ensure the background covers the full screen */
        body {
            font-family: Arial, sans-serif;
            background-color: #ffe5b4; /* Light background color */
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full viewport height */
            text-align: center;
        }

        .form-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);

            /* Increased width from 800px to 1000px */
            max-width: 500px; /* Set max width to 1000px */
            width: 100%; /* Remove width: 100% to allow content to stretch based on max-width */
            box-sizing: border-box;
        }

        /* Heading Style */
        h2 {
            font-size: 2.5em;
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

        /* Form Grouping */
        .form-group {
            margin-bottom: 10px;
        }

        /* Label Style */
        .form-group label {
            font-size: 1.1em;
            color: #333;
            display: block;
            margin-bottom: 8px;
        }

        /* Input Field Style */
        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Focus effect for input fields */
        .form-group input:focus {
            border-color: #6c7ae0;
            outline: none;
        }



        /* Submit Button Style */
        button {
            background-color: #6c7ae0;
            color: white;
            padding: 12px 20px;
            font-size: 1.1em;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 15px; /* Add margin for spacing */
        }

        /* Hover effect for button */
        button:hover {
            background-color: #5a65d1;
        }

        /* Link Style */
        a {
            display: inline-block;
            margin-top: 15px;
            color: #333;
            text-decoration: none;
            font-size: 1.1em;
        }

        /* Hover effect for link */
        a:hover {
            color: #6c7ae0;
        }
    </style>
</head>
<body>

        <div class="form-container">

    <h2>Advanced Search</h2>

    <form action="/advanced" method="GET">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" placeholder="Search by Title">
            </div>

            <div class="form-group">
                <label for="author">Author:</label>
                <input type="text" id="author" name="author" placeholder="Search by Author">
            </div>

            <div class="form-group">
                <label for="priceMin">Price Range (Min):</label>
                <input type="number" id="priceMin" name="priceMin" step="0.01" placeholder="Minimum Price">
            </div>

            <div class="form-group">
                <label for="priceMax">Price Range (Max):</label>
                <input type="number" id="priceMax" name="priceMax" step="0.01" placeholder="Maximum Price">
            </div>

            <div class="form-group">
                <label for="stock">Stock (Min):</label>
                <input type="number" id="stock" name="stock" placeholder="Minimum Stock">
            </div>

            <button type="submit">Search/All-Books</button>

    </form>
  </div>
    <a href="/homepage">Back to Home</a>

</body>
</html>
