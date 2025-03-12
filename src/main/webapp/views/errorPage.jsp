<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>Error</h1>
    <p>Sorry, something went wrong!</p>
    <p>Error details:</p>
    <ul>
        <li><strong>Error Message:</strong> <%= exception.getMessage() %></li>
        <li><strong>Exception Type:</strong> <%= exception.getClass().getName() %></li>
        <li><strong>Stack Trace:</strong></li>
        <pre><%= exception.getStackTrace() %></pre>
    </ul>
</body>
</html>
