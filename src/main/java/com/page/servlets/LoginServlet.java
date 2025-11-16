package com.page.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.page.daoimpl.UserDaoImpl;
import com.page.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/callingLoginServlet")
public class LoginServlet extends HttpServlet{
//	private static final int MAX_ATTEMPTS = 3;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDaoImpl userImpl = new UserDaoImpl();
		String emailEntered = req.getParameter("email");
		String enteredPassword = req.getParameter("password");
		String userPassword = userImpl.getUserPassword(emailEntered);
		User user = userImpl.getUser(emailEntered);

		HttpSession session = req.getSession();
		//	        Integer attempts = (Integer) session.getAttribute("loginAttempts");
		//	        if (attempts == null) {
		//	            attempts = MAX_ATTEMPTS;
		//	        }

		resp.setContentType("text/html");
		if (!userImpl.isEmailRegistered(emailEntered)) {
			req.setAttribute("errorMessage", "Error: An account with this email doesn't exists.");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			return; 
		}

		if (enteredPassword.equals(userPassword)) {
			//	            session.removeAttribute("loginAttempts");
			//	            session.setAttribute("user", user);
			//	            user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
			//                userImpl.updateUser(user);
			session.setAttribute("user", user);
			req.setAttribute("successMessage", "Login Successful! Welcome, " + user.getFname()+" "+ user.getLname() + ".");
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		} else {
			String errorMessage = "Incorrect password.";
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("emailEntered", emailEntered);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
