<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
            height: 90vh; /* Full viewport height */
            text-align: center;
        }

        /* Style for the form container */
        .login-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
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
            margin-bottom: 15px;
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
            margin-top: 15px;
            width: 100%;
        }

        /* Hover effect for link */
        .footer-link:hover {
            color: #6c7ae0;
        }

        /* Error message for login failure */
        .error-message {
            color: red;
            text-align: center;
            font-size: 1.1em;
            margin-bottom: 15px;
        }
        h1 {
                     margin: 20px 0;
                     color: #333;
                     font-size: 3.5em;
                     font-weight: bold;
                 }

                 /* Subtitle Styling */
                 #h {
                     margin: 0;
                     color: #777;
                     font-size: 1.8em;
                     font-weight: normal;
                     margin-bottom: 20px;
                 }
    </style>
</head>
<body>
 <h1>Book Store</h1>

    <h2 id="h">Your one-stop shop for all your favorite books!</h2>
    <div class="login-container">
        <h2>Login</h2>

        <!-- Display error message if any -->
       <c:if test="${not empty errorMessage}">
           <div class="error-message">
               ${errorMessage}
           </div>
       </c:if>

        <c:if test="${not empty param.error}">
                <div class="error-message" style="color: red;">
                    ${param.error}
                </div>
            </c:if>

        <!-- Login form -->
        <form action="/login" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" class="input-field" placeholder="Username" required />
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" class="input-field" placeholder="Password" required />
            </div>
            <button type="submit">Login</button>
        </form>
 </div>
        <a href="/signup" class="footer-link">Sign up</a>

</body>
</html>
