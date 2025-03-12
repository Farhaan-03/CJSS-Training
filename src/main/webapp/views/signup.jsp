<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sign Up</title>
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
               height: 80vh; /* Full viewport height */
               text-align: center;
           }

           /* Style for the form container */
           .form-container {
               background-color: white;
               padding: 40px;
               border-radius: 10px;
               box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
               width: 100%;
               max-width: 500px; /* Max width of form container */
               margin: 10px;
               box-sizing: border-box;
               flex: 1;
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

           /* Error message style */
           .error {
               color: red;
               font-size: 0.9em;
               margin-top: 5px;
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
           }

           /* Hover effect for button */
           button:hover {
               background-color: #5a65d1;
           }

           /* Link Style */
           .footer-link {

               text-align: center;
               color: #333;
               text-decoration: none;
               font-size: 1.1em;
               width: 100%;
           }

           /* Hover effect for link */
           .footer-link:hover {
               color: #6c7ae0;
           }

       </style>
</head>
<body>
<div class="form-container">

 <h1>Sign Up</h1>
   <p>${NameError}</p>
    <form:form action="/signup" method="post" modelAttribute="customer">

        <div class="form-group">
            <form:label path="customerName">Customer Name:</form:label>
            <form:input path="customerName" />
            <form:errors path="customerName" class="error"/>
        </div>

        <div class="form-group">
            <form:label path="email">Customer Email:</form:label>
            <form:input  path="email" />
            <form:errors path="email" class="error"/>
        </div>

        <div class="form-group">
            <form:label path="phoneNo">Customer PhoneNo:</form:label>
            <form:input  path="phoneNo" />
            <form:errors path="phoneNo" class="error"/>
        </div>

        <div class="form-group">
              <form:label path="password">Customer Password:</form:label>
            <form:input path="password" />
            <form:errors path="password" class="error"/>
        </div>

        <div>
            <button type="submit">Sign Up</button>
        </div>
    </form:form>
</div>
    <a href="/login" class="footer-link">Sign in</a>
</body>
</html>
