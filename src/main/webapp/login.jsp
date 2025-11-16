<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

 <div class="form-container">
        <form action="callingLoginServlet" method="post">
            <h2>Login</h2>
            <p class="error-message" style="color: red; text-align: center;">${errorMessage}</p>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" value="${emailEntered}" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>

            <button type="submit" class="submit-btn">Login</button>

            <div class="form-link">
                <p>Don't have an account? <a href="registration.jsp">Register here</a></p>
            </div>
        </form>
    </div>

</body>
</html>


