package com.rahul.employee.Methods;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.rahul.employee.Bean.Employee;
import com.rahul.employee.DAO.EmployeeDAO;



public class Allmethods {

	
	public Connection getConnection()
	{
		String a="hellow";
		String url = "jdbc:mysql://localhost:3001/hbnet_demo?useSSL=false";    
	    String driverName = "com.mysql.jdbc.Driver";   
	    String username = "root";   
	    String password = "root";
		Connection con= null;
		try {
			Class.forName(driverName);
			con=DriverManager.getConnection(url, username, password);
		//System.out.println("connection build...");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("something went wrong.."+e.getMessage());
		}
		return con;
	}
	
	
public void AddEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		
	
		String empfname=request.getParameter("Empfname");
		String empmname=request.getParameter("Empmname");
		String emplname=request.getParameter("Emplname");
		String empid=request.getParameter("Empid");
		String emppass=request.getParameter("Emppass");
		String empdesignation=request.getParameter("Empdesignation");
		String emplocation=request.getParameter("Emplocation");
		String empcontact =request.getParameter("Empcontact");
		String empbirthdate=request.getParameter("Empbirthdate");
		String empjoindate=request.getParameter("Empjoindate");
		String empemail=request.getParameter("Empemail");
		String empdepartment=request.getParameter("Empdepartment");
		String empaddress= request.getParameter("Empaddress");
		String empgender= request.getParameter("Empgender");
		String password= encpass(emppass);
		String emprole="USER";
		//System.out.println(password);
		
		Employee emp= new Employee(empid, empfname, emplname, empmname, empemail, empjoindate, emplocation, empdesignation, empbirthdate, password, empcontact, emprole, empdepartment, empaddress, empgender);
		EmployeeDAO empdao= new EmployeeDAO();
		boolean success=empdao.insertEMP(emp);
		
		if(success)
		{
			request.setAttribute("msg", "Employee successfully added..");
			RequestDispatcher rd= request.getRequestDispatcher("AddEmployee.jsp");
			rd.forward(request, response);
		}
		else
		{
			if(success==false)
			{
				request.setAttribute("msg", empid+" is already resgisterd.");
				RequestDispatcher rd= request.getRequestDispatcher("AddEmployee.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", " Something went wrong!");
				RequestDispatcher rd= request.getRequestDispatcher("AddEmployee.jsp");
				rd.forward(request, response);
			}
				
		}
		
	}
	

			private static MessageDigest md;
		
		public String encpass(String pass)
			{
		    try {
		        md = MessageDigest.getInstance("MD5");
		        byte[] passBytes = pass.getBytes();
		        md.reset();
		        byte[] digested = md.digest(passBytes);
		        StringBuffer sb = new StringBuffer();
		        for(int i=0;i<digested.length;i++){
		            sb.append(Integer.toHexString(0xff & digested[i]));
		        }
		        return sb.toString();
		    } catch (NoSuchAlgorithmException ex) {
		       System.out.println(ex.getMessage());
		    }
		        return null;

			}
		

		public void Deleteemp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 int empid=Integer.parseInt(request.getParameter("empid"));
			 boolean delete= new EmployeeDAO().DeleteEmployee(empid);
			 
			 if(delete)
			 {		RequestDispatcher rd= request.getRequestDispatcher("/EmployeeData");
				 request.setAttribute("msg","Employee Id successfully Deleted.");
				 rd.forward(request, response);
			 }
			 else
			 {
			 RequestDispatcher rd= request.getRequestDispatcher("/EmployeeData");
			 request.setAttribute("msg","Something went wrong!! Please try agin.");
			 rd.forward(request, response);
			 }
		}

		public void Editemp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String empid=request.getParameter("empid");
			List <Employee> empdetails = new EmployeeDAO().getEmpdetails(empid);
			RequestDispatcher rd= request.getRequestDispatcher("UpdateDetails.jsp");
			request.setAttribute("empdetails", empdetails);
			System.out.println(empdetails+"here");
			rd.forward(request, response);
			
		}

		public void EmpList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd= request.getRequestDispatcher("EmployeeDetails.jsp");
			List<Employee> emplist= new EmployeeDAO().getAllEmployees();
			request.setAttribute("emplist", emplist);
			rd.forward(request, response);
		}
		
		public void EmpData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd= request.getRequestDispatcher("Lock.jsp");
			List<Employee> EmpData= new EmployeeDAO().getEmpData();
			request.setAttribute("EmpData", EmpData);
			rd.forward(request, response);
		}
		
		public void Updaterole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String role=request.getParameter("emprole");
			String empid= request.getParameter("empid");
			System.out.println(role+" "+empid);
			String msg=null;
			boolean update = new EmployeeDAO().updaterole(role, empid);
			
			if(update)
			{	 response.setContentType("text/html;charset=UTF-8");
	        	PrintWriter out = response.getWriter();
	        	out.print("Role Updated Successfully..");
	        	out.close();
			}			
			else
			{
				 	response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        out.print("Something Went Wrong..");
			        out.close();
			}
			
		}

		public void Updatelock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String update=request.getParameter("status");
			String empid= request.getParameter("empid");
			
			boolean lock = new EmployeeDAO().updatelock(update, empid);
			
			if(lock)
			{	 response.setContentType("text/html;charset=UTF-8");
	        	PrintWriter out = response.getWriter();
	        	out.print("Role Updated Successfully..");
	        	out.close();
			}			
			else
			{
				 	response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        out.print("Something Went Wrong..");
			        out.close();
			}
			
		}
		

		public void AddDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String empid=request.getParameter("empid");
			String designation= request.getParameter("designation");
			System.out.println(designation);
			boolean added = new EmployeeDAO().addDesignation(designation, empid);
			
			if(added)
			{	 response.setContentType("text/html;charset=UTF-8");
	        	PrintWriter out = response.getWriter();
	        	out.print("Designation Added Successfully..");
	        	out.close();
			}			
			else
			{
				 	response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        out.print("Designation already exists or something went wrong..");
			        out.close();
			}
			
		}
		
		
		public void AddDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String empid=request.getParameter("empid");
			String department= request.getParameter("department");
			System.out.println(department);
			boolean added = new EmployeeDAO().addDepartment(department, empid);
			System.out.println(added);
			if(added)
			{	 response.setContentType("text/html;charset=UTF-8");
	        	PrintWriter out = response.getWriter();
	        	out.print("Department Added Successfully..");
	        	out.close();
			}			
			else
			{
				 	response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        out.print("Department already exists or something went wrong..");
			        out.close();
			}
		}
	public void Updateemp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("inside update");
			String empid= request.getParameter("empcode");
			Employee emp= new Employee();
			emp.setEmpid(empid);
			emp.setEmpfname(request.getParameter("empfname"));
			emp.setEmpmname(request.getParameter("empmname"));
			emp.setEmplname(request.getParameter("emplname"));
			emp.setEmpemail(request.getParameter("empemail"));
			emp.setEmpdesignation(request.getParameter("empdesignation"));
			emp.setEmpdepartment(request.getParameter("empdepartment"));
			emp.setEmplocation(request.getParameter("emplocation"));
			//System.out.println(emp);
			boolean done = new EmployeeDAO().UpdateEmployee(emp);
			
			if(done)
			{
				RequestDispatcher rd= request.getRequestDispatcher("EmployeeData");
				request.setAttribute("msg", emp.getEmpid()+" Updated successfully !!");
				rd.forward(request, response);
				
				
			}
			
			RequestDispatcher rd= request.getRequestDispatcher("UpdateDetails.jsp");
			rd.forward(request, response);
		}
	

	
}
