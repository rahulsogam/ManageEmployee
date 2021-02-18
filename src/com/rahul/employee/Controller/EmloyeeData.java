package com.rahul.employee.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahul.employee.Bean.Employee;
import com.rahul.employee.DAO.EmployeeDAO;

/**
 * Servlet implementation class EmloyeeData
 */
@WebServlet("/EmployeeData")
public class EmloyeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			RequestDispatcher rd= request.getRequestDispatcher("EmployeeDetails.jsp");
			List<Employee> emplist= new EmployeeDAO().getAllEmployees();
			request.setAttribute("emplist", emplist);
			rd.forward(request, response);
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
