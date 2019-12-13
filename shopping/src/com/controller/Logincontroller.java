package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CentralDb;
import com.model.Login;

/**
 * Servlet implementation class Logincontroller
 */
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CentralDb db1=new CentralDb();
		String Username=request.getParameter("uname");
		String Password=request.getParameter("pass");
		Login log=new Login();
		log.setUsername(Username);
		log.setPassword(Password);
		try {
			log=db1.validate(Username,Password);
			if(Username.equals(log.getUsername())&& (Password.equals(log.getPassword())))
					{
				HttpSession session=request.getSession(true);
				session.setAttribute("data","Login Successful");
				response.sendRedirect("Welcome.jsp");
				
					}
			else
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("data","Login unSuccessful");
				response.sendRedirect("Login.jsp");	
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
