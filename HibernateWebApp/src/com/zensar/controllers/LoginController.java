package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */

/**
 * @author Chaithrodaya B.S.
 * @version 2.0
 * @creation_date 21st sep 2019 5.35PM
 * @modification_date 28th sep 2019 11.45 AM
 * @copyright Zensar Technologies. All rights reserved.
 */

@WebServlet("/checkuser")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		UserDao userdao = new UserDaoImpl();
		UserService userservice = new UserServiceImpl();
		((UserServiceImpl) userservice).setUserdao(userdao);
		setUserService(userservice);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter();
			User clientUser =new User();
			clientUser.setUsername(username);
			clientUser.setPassword(password);
			//invoking business logic
			
			try
			{
			if(userService.validateUser(clientUser)) 
			{
				//out.println("<p> Dear "+username+" "+" Welcome to Zensar</p>");
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
			}
			
			else
			{
				out.println("<p> Sorry!!! Invalid Credentials</p>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
	}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
