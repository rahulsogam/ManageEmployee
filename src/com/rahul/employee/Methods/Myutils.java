package com.rahul.employee.Methods;

import javax.servlet.http.HttpSession;

import com.rahul.employee.Bean.Employee;

public class Myutils {

	public static void storeEmployee(HttpSession session,Employee emp)
	{
		//System.out.println(emp);
		session.setAttribute("Employee", emp);
		
	}
	
	public Employee getLogedinEmp(HttpSession session) 
	{
		Employee employeedata= (Employee) session.getAttribute("Employee");
		return employeedata;
	}
}
