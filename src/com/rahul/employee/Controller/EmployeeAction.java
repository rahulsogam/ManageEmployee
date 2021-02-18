package com.rahul.employee.Controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rahul.employee.Methods.Allmethods;

@WebServlet("/CRUD")
public class EmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	Allmethods am= new Allmethods();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String actionType = request.getParameter("actionType");
	
		System.out.println(actionType);
		try {
			switch (actionType) 
			{
			case "Add":
				am.AddEmployee(request,response);
				break;
			case "Emplist":
				am.EmpList(request,response);
				break;
			case "Editemp":
				am.Editemp(request,response);
				break;
			case "Updateemp":
				am.Updateemp(request, response);
				break;
			case "Deleteemp":
				am.Deleteemp(request,response);
				break;
			case "Role":
				am.Updaterole(request,response);
				break;
			case "lock":
				am.Updatelock(request,response);
				break;
			case "adddesignation":
				am.AddDesignation(request,response);
				break;
			case "adddept":
				am.AddDepartment(request,response);
				break;	
			default:
				am.EmpData(request,response);
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	}
	 
	 

