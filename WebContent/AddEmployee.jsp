<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="com.rahul.employee.DAO.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<title>ADD EMPLOYEE</title>
<style type="text/css">

.close {
  cursor: pointer;
  position: absolute;
  top: 50%;
  right: 0%;
  padding: 12px 16px;
  transform: translate(0%, -50%);
}
.button1 {
    display: block;
    width: 115px;
    height: 40px;
    background: #5cb85c;
    padding: 3px;
    text-align: center;
    border-radius: 29px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}
.button2 {
    display: block;
    width: 115px;
    height: 40px;
    background: #e00808;
    padding: 3px;
    text-align: center;
    border-radius: 29px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}
</style>
</head>
<body>

<%

List location=new EmployeeDAO().getAllLocation();
List designation=new EmployeeDAO().getAllDesignation();
List department=new EmployeeDAO().getAllDepartment();
%>

<jsp:include page="Header.jsp"></jsp:include>

<e:if test="${not empty Employee}">
<e:set var="msg" value="" scope="session" />
<form action="CRUD" method="post" class="container form" autocomplete="off">
<h2>Personal Details</h2>
<hr>

<div class=" form-group row">
 <div class="col-lg-4" >
 <input class="form-control" type="text" name="Empfname" placeholder="First Name"  required="required">
</div>
 <div class="col-lg-4 ">
 <input type="text"  class="form-control" name="Empmname" placeholder="Middle Name" required="required">
 </div>
  <div class="col-lg-4 ">
 <input type="text"  class="form-control" name="Emplname" placeholder="Last name" required="required" >
 </div>
 </div>
 


<div class=" form-group row">
 <div class="col-lg-4" >
 <input class="form-control" type="text" name="Empcontact" placeholder="Contact" required="required" minlength="10" maxlength="10">
 </div>
 <div class="col-lg-4 ">
 <textarea rows="1" cols="1" class="form-control" type="text" name="Empaddress" placeholder="Address" required="required"></textarea>
 </div>
 <div class="col-lg-4 ">
 <input type="text"  class="form-control" name="Empbirthdate" placeholder="Birthdate" required="required" onfocus="(this.type='date')">
 </div>
 </div>
 
<div class=" form-group row form-check">
 
   <div class="col-lg-4">
   <label>
   		SELECT GENDER : 
   	</label>
   	<label>
   		Male 
   	</label>	
   	<input  type="radio" value="Male"  name="Empgender">
   	<label style="margin-left: 10px">
   		Female 
   	</label>	
   	<input  type="radio" value="Female"  name="Empgender" >
   	<label style="margin-left: 10px">
   		Other
   	</label>	
   	<input  type="radio" value="other"   name="Empgender">
   
   </div>
</div>
 
 <h2>Professional  Details</h2>
<hr>
 
  <div class=" form-group row">
  <div class="col-lg-4" >
 	 <input type="text" name="Empid" placeholder="Employee Id" required="required"   class="form-control">
  </div>
  
   <div class="col-lg-4" >
 	 <input type="password" name="Emppass" placeholder="Password" required="required"   class="form-control">
  </div>
  
  <div class="col-lg-4" >
 	 <input type="Email" name="Empemail" placeholder="Email" required="required"   class="form-control">
  </div>
 </div>
 <div class=" form-group row">
  <div class="col-lg-4" >
  <select name="Emplocation" class="form-control form-select-lg mb-3 center" style="height:32px; " required >
  <option selected="selected" disabled="disabled">Location</option>
 	<%for(Object locationame:location){ %>
  	<option  value="<%=locationame%>"><%=locationame%></option>
  <% } %>
  </select>
  </div>
  
  <div class="col-lg-4" >
    <select name="Empdesignation" class="form-control form-select-lg mb-3 center" style="height:32px;  " required >
  <option selected="selected" disabled="disabled">Designation</option>
 	<%for(Object designationname:designation){ %>
  	<option  value="<%=designationname%>"><%=designationname%></option>
  <% } %>
  </select>  
 </div>
 
 <div class="col-lg-4" >
    <select name="Empdepartment" class="form-control form-select-lg mb-3 center" style="height:32px;  " required >
  <option selected="selected" disabled="disabled">Department</option>
 	<%for(Object departmentnname:department){ %>
  	<option  value="<%=departmentnname%>"><%=departmentnname%></option>
  <% } %>
  </select>  
 </div>
 
 
 <div class="col-lg-4" >
 <input type="text"  class="form-control" name="Empjoindate" placeholder="Join Date" required="required" onfocus="(this.type='date')">
 </div>
 
 </div>

 <input type="hidden" name="actionType" value="Add" >
 <div class="text-center border border-light container" >
   	<li>
   	 <input type="submit" class="button1" value="Add">
	 <input type="reset" class="button2" value="Cancel">
	 </li>
 </div>

	<e:if test="${not empty msg}">
		<div class="alert alert-info alert-dismissible fade show" role="alert">
			<strong style="align-content: center; "><e:out value="${msg}" /></strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
		<e:set var="msg" value="" scope="request" />
	</e:if>
</form>
</e:if>

<e:if test="${ empty Employee}">
	<e:redirect url="Login.jsp"></e:redirect>
</e:if>



<%-- <% if(request.getAttribute("msg")!=null)
		{ %>
		<a style="margin-left:150px;" class="table-danger">
		 <e:out value='${requestScope.msg }'></e:out><span class="close">&times;</span>
		</a>
		<%} %> --%>


</body>
</html>