<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Books</title>
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

        /* Table Styling */
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 20px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #D98586;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        tr:nth-child(even) td {
            background-color: #f1f1f1;
        }

        /* Action Buttons Styling */
        a {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
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

<h2>All Books</h2>

<table border="1">
    <thead>
        <tr>
            <th>Book Id</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Stock</th>
           <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.stock}</td>
                <td>
                  <a href="/delete-book/${book.bookId}">Remove</a>
                   <a href="/update-book/${book.bookId}">Update</a>
               </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="/admin">back to Home</a>

</body>
</html>
