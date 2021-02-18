package com.rahul.employee.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rahul.employee.Bean.Employee;
import com.rahul.employee.DAO.EmployeeDAO;
import com.rahul.employee.Methods.Allmethods;
import com.rahul.employee.Methods.Myutils;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	Allmethods am= new Allmethods();
	EmployeeDAO dao= new EmployeeDAO();
	Myutils mu= new Myutils();
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Emp= request.getParameter("Empid");
		if(Emp== " " || Emp==null)
		{
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "Please enter valid Employee Id.");
			rd.forward(request, response);
		}
		else
		{
		//int Empid=Integer.parseInt(Emp);
		String pass= request.getParameter("Emppass");
		pass=am.encpass(pass);
		Employee emp;
		
		HttpSession session = request.getSession() ;
		emp=dao.Emplogin(Emp, pass);
		
		mu.storeEmployee(session, emp);
		System.out.println(session.getAttribute("Employee"));
		if(session.getAttribute("Employee")==null)
		{		
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "Wrong Username or Password. Please try again !!");
			rd.forward(request, response);
		}
		else
			
			//System.out.println(session.getAttribute("Employee"));
			emp=mu.getLogedinEmp(session);
			response.sendRedirect("Main.jsp");
		}
	}
}
	

	
