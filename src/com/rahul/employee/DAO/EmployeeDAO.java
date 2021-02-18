package com.rahul.employee.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.rahul.employee.Bean.Employee;
import com.rahul.employee.Methods.Allmethods;
import com.rahul.employee.Methods.Myutils;


public class EmployeeDAO {
		Allmethods am;
		Myutils mu;
		
		Date d= new Date();
		int date= d.getDate();
		int month=d.getMonth()+1;
		int year=d.getYear();
		
		
		
		public boolean Empexist(String string)
		{
			
			boolean exist= false;
			String sql= " select * from employee where Emp_id= '"+string+"' ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery(sql);
				if(rs.next())
				{
					exist=true;
					return exist;
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return exist;
		}
	
		public boolean Desigexist(String designation)
		{
			
			boolean exist= false;
			String sql= " select * from designation where designation_name= '"+designation+"' ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery(sql);
				if(rs.next())
				{
					exist=true;
					return exist;
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return exist;
		}
		
		public boolean Deptexist(String department)
		{
			
			boolean exist= false;
			String sql= " select * from department where department_name= '"+department+"' ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery(sql);
				if(rs.next())
				{
					exist=true;
					return exist;
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return exist;
		}
		
		public boolean insertEMP(Employee emp) throws ClassNotFoundException
		{
			System.out.println(emp.getEmpid()+"here");
			
			boolean exist=Empexist(emp.getEmpid());
			boolean insert=false;
			String Sql= "insert into employee "
					+ "(Emp_id,Emp_fname,Emp_mname,Emp_lname,Emp_location,Emp_designation,Emp_birthdate,Emp_joindate,Emp_pass,"
					+ "Emp_contact,Emp_role,Emp_department,Emp_lock,Emp_address,Emp_mail,Emp_gender)"
					+ " Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			if(exist)
			{
				return false;
			}
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(Sql);
				ps.setString(1, emp.getEmpid());
				ps.setString(2, emp.getEmpfname());
				ps.setString(3, emp.getEmpmname());
				ps.setString(4, emp.getEmplname());
				ps.setString(5, emp.getEmplocation());
				ps.setString(6, emp.getEmpdesignation());
				ps.setString(7, emp.getEmpbirthdate());
				ps.setString(8, emp.getEmpjoindate());
				ps.setString(9, emp.getEmppass());
				ps.setString(10, emp.getEmpcontact());
				ps.setString(11, emp.getEmprole());
				ps.setString(12, emp.getEmpdepartment());
				ps.setString(13, "No");
				ps.setString(14, emp.getEmpaddress());
				ps.setString(15, emp.getEmpemail());
				ps.setString(16,emp.getEmpgender());
				
				
				insert= ps.executeUpdate()>0;
				return insert;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
		}


		public List<Employee> getAllEmployees() {
			int i=0;
			List<Employee> employeelist= new Vector<>();
			String sql="select * from employee ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String empfname=rs.getString("Emp_fname");
					String empmname=rs.getString("Emp_mname");
					String emplname=rs.getString("Emp_lname");
					String empid=rs.getString("Emp_id");
					String empdesignation=rs.getString("Emp_designation");
					String empdepartment=rs.getString("Emp_department");
					String emplocation=rs.getString("Emp_location");
					String empemail =rs.getString("Emp_mail");
					String emppass=rs.getString("Emp_pass");
					String emprole=rs.getString("Emp_role");
					String empaddress=rs.getString("Emp_address");
					
					Employee emp= new Employee(empid, empfname, emplname, empmname, empemail, emplocation, empdesignation, emppass, emprole, empdepartment, empaddress);
					employeelist.add(i, emp);
					i++;
				}
				//System.out.println(employeelist);
				return employeelist;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		public List<Employee> getEmpData() {
			int i=0;
			List<Employee> employeelist= new Vector<>();
			String sql="select * from employee ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String empfname=rs.getString("Emp_fname");
					String empmname=rs.getString("Emp_mname");
					String emplname=rs.getString("Emp_lname");
					String empid=rs.getString("Emp_id");
					String empjoindate=rs.getString("Emp_joindate");
					String empbirthdate=rs.getString("Emp_birthdate");
					String empdesignation=rs.getString("Emp_designation");
					String empdepartment=rs.getString("Emp_department");
					String emplocation=rs.getString("Emp_location");
					String empcontact=rs.getString("Emp_contact");
					String empgender=rs.getString("Emp_gender");
					
					String empemail =rs.getString("Emp_mail");
					String emppass=rs.getString("Emp_pass");
					String emprole=rs.getString("Emp_role");
					String empaddress=rs.getString("Emp_address");
					String emplock= rs.getString("Emp_lock");
					Employee emp= new Employee(empid, empfname, emplname, empmname, empemail, empjoindate, emplocation, empdesignation, empbirthdate, emppass, empcontact, emprole, empdepartment, empaddress, empgender, emplock);
					employeelist.add(i, emp);
					i++;
				}
				//System.out.println(employeelist);
				return employeelist;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		public Employee Emplogin(String empcode,String pass) {
			Employee emp= new Employee();
			
			System.out.println("here"+pass+" "+empcode);
			String sql="select * from employee where Emp_id= ? and Emp_pass= ? and emp_lock='No' ";
			
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1, empcode);
				ps.setString(2,pass);
				ResultSet rs= ps.executeQuery();
				
				if(rs.next())
				{
					
					emp.setEmpfname(rs.getString("Emp_fname"));
					emp.setEmpmname(rs.getString("Emp_mname"));
					emp.setEmplname(rs.getString("Emp_lname"));
					emp.setEmpid(rs.getString("Emp_id"));
					emp.setEmpemail(rs.getString("Emp_mail"));
					emp.setEmpjoindate(rs.getString("Emp_joindate"));
					emp.setEmpcontact(rs.getString("Emp_contact"));
					emp.setEmpbirthdate(rs.getString("Emp_birthdate"));
					emp.setEmplocation(rs.getString("Emp_location"));
					emp.setEmpaddress(rs.getString("Emp_address"));
					emp.setEmpdepartment(rs.getString("Emp_department"));
					emp.setEmpdesignation(rs.getString("Emp_designation"));
					emp.setEmppass(rs.getString("Emp_pass"));
					emp.setEmprole(rs.getString("Emp_role"));
					return emp;
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		
		public List<Employee> getEmpdetails(String empid) {
			
			List<Employee> employeelist= new ArrayList<>();
			String sql="select * from employee where Emp_id='"+empid+"' ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					
					String empfname=rs.getString("Emp_fname");
					String empmname=rs.getString("Emp_mname");
					String emplname=rs.getString("Emp_lname");
					String empid1=rs.getString("Emp_id");
					String empdesignation=rs.getString("Emp_designation");
					String empdepartment=rs.getString("Emp_department");
					String emplocation=rs.getString("Emp_location");
					String empemail =rs.getString("Emp_mail");
					String emppass=rs.getString("Emp_pass");
					String emprole=rs.getString("Emp_role");
					String empaddress=rs.getString("Emp_address");
					Employee emp= new Employee(empid1, empfname, emplname, empmname, empemail, emplocation, empdesignation, emppass, emprole, empdepartment, empaddress);
					
					employeelist.add(emp);
					
				}
				//System.out.println(employeelist);
				return employeelist;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		
		public boolean DeleteEmployee(int empid)
		{
			boolean delete = false;
			String sql="delete from employee where Emp_id= ? ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setInt(1,empid);
				delete= ps.executeUpdate()>0;
				delete=true;
				return delete;
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return delete;
				
		}
		
		public boolean UpdateEmployee(Employee emp)
		{
			System.out.println("inside methods");
			boolean update = false;
			System.out.println(emp.getEmpdepartment()+" "+emp.getEmpdesignation());
			String sql="UPDATE employee SET Emp_id=?,Emp_fname=?,Emp_mname=?,Emp_lname=?,Emp_designation=?,Emp_department=?,Emp_location=?, "
					+ "Emp_mail=? where Emp_id='"+emp.getEmpid()+"' ";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1,emp.getEmpid());
				ps.setString(2,emp.getEmpfname());
				ps.setString(3,emp.getEmpmname());
				ps.setString(4,emp.getEmplname());
				ps.setString(5,emp.getEmpdesignation());
				ps.setString(6,emp.getEmpdepartment());
				ps.setString(7, emp.getEmplocation());
				ps.setString(8, emp.getEmpemail());

				System.out.println(sql);
				update= ps.executeUpdate()>0;
				return update;
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return update;
				
		}
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public ArrayList<String> getAllLocation()
		{
			int i=0;
			ArrayList<String> location= new ArrayList<>();
			PreparedStatement psmt= null;
			String sql="select * from location order by location_name asc ";
			try {

				Connection con=new Allmethods().getConnection();
				psmt= con.prepareStatement(sql);
				ResultSet rs= psmt.executeQuery();
				while (rs.next())
				{
					String locationnames = rs.getString("location_name");
					location.add(locationnames);
					System.out.println(location);
					i++;
				}
				return location;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		public ArrayList<String> getAllDesignation()
		{
			
			ArrayList<String> designation= new ArrayList<>();
			PreparedStatement psmt= null;
			String sql="select * from designation order by designation_name asc ";
			try {

				Connection con=new Allmethods().getConnection();
				psmt= con.prepareStatement(sql);
				ResultSet rs= psmt.executeQuery();
				while (rs.next())
				{
					String designationnames = rs.getString("designation_name");
					designation.add(designationnames);
					System.out.println(designation);
					
				}
				return designation;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		public ArrayList<String> getAllDepartment()
		{
			
			ArrayList<String> departments= new ArrayList<>();
			PreparedStatement psmt= null;
			String sql="select * from department order by department_name asc ";
			try {

				Connection con=new Allmethods().getConnection();
				psmt= con.prepareStatement(sql);
				ResultSet rs= psmt.executeQuery();
				while (rs.next())
				{
					String departmentnames = rs.getString("department_name");
					departments.add(departmentnames);
					//System.out.println(designation);
					
				}
				return departments;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		public boolean updaterole(String role,String empid) 
		{
			boolean update=false;
			System.out.println(role+""+empid);
			String sql="UPDATE  employee SET emp_role=? where Emp_id='"+empid+"'";
			
			try {
				Connection con=  new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1,role);
				System.out.println(sql);
				update=ps.executeUpdate()>0;
				return update;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean updatelock(String update,String empid) 
		{
			boolean lock=false;
			System.out.println(update+""+empid);
			String sql="UPDATE  employee SET emp_lock=? where Emp_id='"+empid+"'";
			
			try {
				Connection con=  new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1,update);
				System.out.println(sql);
				lock=ps.executeUpdate()>0;
				return lock;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean addDesignation(String designation,String empid) 
		{
			boolean exist=Desigexist(designation);
			boolean insert=false;
			String Sql= "insert into designation "
					+ "(designation_name,created_date,created_by)"
					+ " Values(?,?,?) ";
			if(exist)
			{
				return false;
			}
			try {
				LocalDateTime myDateObj = LocalDateTime.now();  
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			    String formattedDate = myDateObj.format(myFormatObj);  
		  
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(Sql);
				
				ps.setString(1,designation.toUpperCase());
				ps.setString(2,formattedDate );
				ps.setString(3, empid);
				insert= ps.executeUpdate()>0;
				return insert;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
		}
		
		public boolean addDepartment(String department,String empid) 
		{
			boolean exist=Deptexist(department);
			boolean insert=false;
			String Sql= "insert into department "
					+ "(department_name,created_by,created_date)"
					+ " Values(?,?,?) ";
			if(exist)
			{
				return false;
			}
			try {
				LocalDateTime myDateObj = LocalDateTime.now();  
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			    String formattedDate = myDateObj.format(myFormatObj);  
		  
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(Sql);
				
				ps.setString(1,department.toUpperCase());
				ps.setString(2, empid);
				ps.setString(3,formattedDate );
				
				insert= ps.executeUpdate()>0;
				return insert;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
		}
		
		 @SuppressWarnings("rawtypes")
		public List<String> getRoles()
		 {		int i=0;
		//
			 ArrayList<String> roles= new ArrayList<>();
			 String query="select * from tbl_role";
			try {
				Connection con= new Allmethods().getConnection();
				PreparedStatement ps= con.prepareStatement(query);
				ResultSet rs= ps.executeQuery();
				 System.out.println("inside methods"+query);
				while(rs.next())
				{
					
					String role=rs.getString("role_name");
					
					roles.add(i, role);
					i++;
				}
				
				return roles;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			 
		 }
		
		
		
}
