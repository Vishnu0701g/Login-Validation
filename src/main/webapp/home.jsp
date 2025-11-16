<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f7f6; 
        color: #333; 
        margin: 0;
        padding: 40px 20px;
        text-align: center; 
    }

    h1 {
        color: #2c3e50; 
        font-size: 2.5em;
        margin-bottom: 0.5em;
        border-bottom: 3px solid #3498db; 
        display: inline-block;
        padding-bottom: 5px;
    }

    p {
        font-size: 1.1em;
        line-height: 1.6;
        margin-top: 20px;
    }


    .success {
        
        color: #27ae60; 
        background-color: #e8f8f5; 
        border: 2px solid #2ecc71; 
        font-weight: bold;
        padding: 15px 30px;
        margin: 20px auto 30px auto; 
        border-radius: 8px; 
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); 
        display: block; 
        max-width: 600px;
    }

    .logout-form {
        margin-top: 40px;
    }

    .glowing-button {
        padding: 12px 25px;
        border: none;
        border-radius: 30px; 
        font-size: 1.1em;
        font-weight: 700;
        cursor: pointer;
        
        color: #fff;
        background-color: #e74c3c; 
        box-shadow: 0 0 5px #e74c3c; 
        transition: all 0.3s ease-in-out;
    }

    .glowing-button:hover {
        background-color: #c0392b; 
        
        box-shadow: 
            0 0 10px rgba(231, 76, 60, 0.8), 
            0 0 50px rgba(255, 107, 107, 0.3); 
            0 0 25px rgba(255, 107, 107, 0.6), 
        
        transform: scale(1.05); 
    }

    .glowing-button:active {
        background-color: #a5281b; 
        box-shadow: 0 0 5px #e74c3c inset;
        transform: scale(1.0); 
    }
</style>
</head>
<body>

    <h1>Welcome to the Home Page!</h1>
    
    <% 
        String successMsg = (String) request.getAttribute("successMessage");
        if (successMsg != null) {
    %>
            <div class="success">
                <%= successMsg %>
            </div>
    <%
        }
    %>

    <form action="logout" method="post" class="logout-form">
        <input type="submit" value="Logout" class="glowing-button">
    </form>

</body>
</html>

