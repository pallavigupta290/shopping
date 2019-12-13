package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.CentralDb;
import com.model.Register;

/**
 * Servlet implementation class Registercontroller
 */
public class Registercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Register r=new Register();
		String Firstname=request.getParameter("fname");
		String Lastname=request.getParameter("lname");
		String Username=request.getParameter("uname");
		String Password=request.getParameter("pass");
		
		r.setFirstname(Firstname);
		r.setLastname(Lastname);
		r.setUsername(Username);
		r.setPassword(Password);
		
		CentralDb db=new CentralDb();
		int i=0;
		try
		{
			i=db.saveData(r);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		if(i>0)
		{
		HttpSession session=request.getSession(true);
		session.setAttribute("data","Registration Successful");
		response.sendRedirect("Login.jsp");
		
		
		}
		if(i<0)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("data","Registration unSuccessful");
			response.sendRedirect("Register.jsp");	
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
