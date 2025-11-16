<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <div class="form-container">
        <form action="callingRegisterServlet" method="post">
            <h2>Create an Account</h2>
            <p class="error-message" style="color: red; text-align: center;">${errorMessage}</p>
            

            <div class="form-row">
                <div class="form-group">
                    <label for="firstname">First Name</label>
                    <input type="text" id="firstname" name="firstname" value="${param.fname}" required>
                </div>
                <div class="form-group">
                    <label for="lastname">Last Name</label>
                    <input type="text" id="lastname" name="lastname" value="${param.lname}" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="age">Age</label>
                    <input type="number" id="age" name="age" value="${param.age}" required>
                </div>
                <div class="form-group">
                    <label>Gender</label>
                    <div class="gender-group">
                        <label><input type="radio" name="gender" value="male" required> Male</label>
                        <label><input type="radio" name="gender" value="female"> Female</label>
                        <label><input type="radio" name="gender" value="other"> Other</label>
                    </div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="${param.email}" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="tel" id="phone" name="phone" value="${param.phnnum}" required>
                </div>
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="confirm_password">Confirm Password</label>
                    <input type="password" id="confirm_password" name="confirm_password" required>
                </div>
            </div>

            <button type="submit" class="submit-btn">Register</button>
            
            <div class="form-link">
                <p>Already have an account? <a href="login.jsp">Login here</a></p>
            </div>
        </form>
    </div>

</body>
</html>


