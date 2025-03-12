<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Book Store</title>
    <meta charset="UTF-8">

    <style>
        /* General Body Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #ffe5b4; /* Light gray background */
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh; /* Full viewport height */
            text-align: center;
        }

        /* Title Styling */
        h1 {
            margin: 20px 0;
            color: #333;
            font-size: 3.5em;
            font-weight: bold;
        }

        /* Subtitle Styling */
        h2 {
            margin: 0;
            color: #777;
            font-size: 1.8em;
            font-weight: normal;
            margin-bottom: 20px;
        }

        /* Styling for navigation links */
        a {
            display: inline-block;
            margin: 10px 20px; /* Adjusted margin for horizontal spacing */
            padding: 15px 40px;
            background-color: #D98586;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.2em;
            width: auto;
            text-align: center;
            transition: background-color 0.3s ease;
        }
        .lang{
            margin:2px;
            padding:5px;
        }

        /* Hover effect for links */
        a:hover {
            background-color: #D98550;
        }

        /* Styling for the link container */
        .link-container {
            display: flex;
            flex-direction: row; /* This makes the links horizontal */
            justify-content: center;
            align-items: center;
            margin-top: 30px;
            flex-wrap: wrap; /* Allows wrapping on smaller screens */
        }

        /* Image or banner styling */
        .banner {
            margin-top: 30px;
            width: 80%;
            max-width: 600px;
            height: auto;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        /* Footer Styling */
        footer {
            position: absolute;
            bottom: 20px;
            text-align: center;
            color: #333;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

    <!-- <h1>Book Store</h1> -->
    <h1>${title}</h1>

    <h2>Your one-stop shop for all your favorite books!</h2>

    <div class="link-container">
        <a href="/book-form">Add Book</a>
        <a href="/searchbook">Search Book</a>
        <a href="/books">All Books</a>
        <a href="/Customers">All Customers</a>
        <a href="/orders">Orders Cart</a>

    </div>

     <a class="lang" href="/change-locale?lang=fr">Switch to French</a>
     <a class="lang" href="/change-locale?lang=en">Switch to English</a>
             <a href="/logout">logout</a>

    <footer>
        <p>&copy; 2025 Book Store | All Rights Reserved</p>
    </footer>

</body>
</html>
