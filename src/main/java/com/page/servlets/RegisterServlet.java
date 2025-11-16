package com.page.servlets;

import java.io.IOException;

import com.page.dao.UserDao;
import com.page.daoimpl.UserDaoImpl;
import com.page.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callingRegisterServlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm_password");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		
		

		UserDao impl = new UserDaoImpl();

		if (!password.equals(confirmPassword)) {
			req.setAttribute("errorMessage", "Error: Passwords do not match.");
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);
			return; 
		}

		if (impl.isEmailRegistered(email)) {
			req.setAttribute("errorMessage", "Error: An account with this email already exists.");
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);
			return; 
		}

		User user = new User(firstname, lastname, email, phone, password, age, gender );
		int result = impl.addUser(user);

		if (result == 1) {
			req.setAttribute("successMessage", "Registration Successful! Welcome, " + firstname+" "+ lastname + ".");
			session.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("errorMessage", "Error: Registration failed. Please try again later.");
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);
		}
	}



}
