package com.rahul.employee.Bean;



public class Employee {
	private String empid;
	private String empfname;
	private String emplname;
	private String empmname;
	private String empemail;
	private String empjoindate;
	private String emplocation;
	private String empdesignation;
	private String empbirthdate;
	private String emppass;
	private String empcontact;
	private String emprole;
	private String empdepartment;
	private String empaddress;
	private String empgender;
	private String emplock;
	
	public String getEmpgender() {
		return empgender;
	}
	public void setEmpgender(String empgender) {
		this.empgender = empgender;
	}
	public Employee() {
		super();
	}
	public Employee(String empid, String empfname, String emplname, String empmname, String empemail,
			String empjoindate, String emplocation, String empdesignation, String empbirthdate, String emppass,
			String empcontact, String emprole,String empdepartment,String empaddress,String empgender) {
		super();
		this.empid = empid;
		this.empfname = empfname;
		this.emplname = emplname;
		this.empmname = empmname;
		this.empemail = empemail;
		this.empjoindate = empjoindate;
		this.emplocation = emplocation;
		this.empdesignation = empdesignation;
		this.empbirthdate = empbirthdate;
		this.emppass = emppass;
		this.empcontact = empcontact;
		this.emprole = emprole;
		this.empdepartment=empdepartment;
		this.empaddress=empaddress;
		this.empgender=empgender;
	}
	public Employee(String empfname, String emplname, String empmname, String empemail, String empjoindate,
			String emplocation, String empdesignation, String empbirthdate, String emppass, String empcontact,
			String emprole,String empdepartment) {
		super();
		this.empfname = empfname;
		this.emplname = emplname;
		this.empmname = empmname;
		this.empemail = empemail;
		this.empjoindate = empjoindate;
		this.emplocation = emplocation;
		this.empdesignation = empdesignation;
		this.empbirthdate = empbirthdate;
		this.emppass = emppass;
		this.empcontact = empcontact;
		this.emprole = emprole;
		this.empdepartment=empdepartment;
	}
	
	
	public Employee(String empid, String empfname, String emplname, String empmname, String empemail,
			String empjoindate, String emplocation, String empdesignation, String empbirthdate, String emppass,
			String empcontact, String emprole, String empdepartment, String empaddress, String empgender,
			String emplock) {
		super();
		this.empid = empid;
		this.empfname = empfname;
		this.emplname = emplname;
		this.empmname = empmname;
		this.empemail = empemail;
		this.empjoindate = empjoindate;
		this.emplocation = emplocation;
		this.empdesignation = empdesignation;
		this.empbirthdate = empbirthdate;
		this.emppass = emppass;
		this.empcontact = empcontact;
		this.emprole = emprole;
		this.empdepartment = empdepartment;
		this.empaddress = empaddress;
		this.empgender = empgender;
		this.emplock = emplock;
	}
	public Employee(String empid, String empfname, String emplname, String empmname, String empemail,
			String emplocation, String empdesignation, String emppass, String emprole, String empdepartment,
			String empaddress) {
		super();
		this.empid = empid;
		this.empfname = empfname;
		this.emplname = emplname;
		this.empmname = empmname;
		this.empemail = empemail;
		this.emplocation = emplocation;
		this.empdesignation = empdesignation;
		this.emppass = emppass;
		this.emprole = emprole;
		this.empdepartment = empdepartment;
		this.empaddress = empaddress;
	}
	public String getEmpdepartment() {
		return empdepartment;
	}
	public void setEmpdepartment(String empdepartment) {
		this.empdepartment = empdepartment;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpfname() {
		return empfname;
	}
	public void setEmpfname(String empfname) {
		this.empfname = empfname;
	}
	public String getEmplname() {
		return emplname;
	}
	public void setEmplname(String emplname) {
		this.emplname = emplname;
	}
	public String getEmpmname() {
		return empmname;
	}
	public void setEmpmname(String empmname) {
		this.empmname = empmname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmpjoindate() {
		return empjoindate;
	}
	public void setEmpjoindate(String empjoindate) {
		this.empjoindate = empjoindate;
	}
	public String getEmplocation() {
		return emplocation;
	}
	public void setEmplocation(String emplocation) {
		this.emplocation = emplocation;
	}
	public String getEmpdesignation() {
		return empdesignation;
	}
	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}
	public String getEmpbirthdate() {
		return empbirthdate;
	}
	public void setEmpbirthdate(String empbirthdate) {
		this.empbirthdate = empbirthdate;
	}
	public String getEmppass() {
		return emppass;
	}
	public void setEmppass(String emppass) {
		this.emppass = emppass;
	}
	public String getEmpcontact() {
		return empcontact;
	}
	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}
	public String getEmprole() {
		return emprole;
	}
	public void setEmprole(String emprole) {
		this.emprole = emprole;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public String getEmplock() {
		return emplock;
	}
	public void setEmplock(String emplock) {
		this.emplock = emplock;
	}
	
	
	
}
