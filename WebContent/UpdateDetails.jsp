<%@page import="com.rahul.employee.DAO.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="css/style.css" rel="stylesheet" type="text/css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<%

List location=new EmployeeDAO().getAllLocation();
List designation=new EmployeeDAO().getAllDesignation();
List department=new EmployeeDAO().getAllDepartment();
%>

<jsp:include page="Header.jsp"></jsp:include>

<e:if test="${not empty Employee}">
	<form action="CRUD" method="post" class="container form " style="padding-top: 50px">
	<e:forEach items="${empdetails}" var="Empdetails">
	<div class=" form-group row">
	<label for="inlineFormCheck" class="form-check-label">Employee Code:</label>
 		<div class="col-lg-2" >
 		
		<input class="form-control form-control-sm" type="text" value="<e:out value='${Empdetails.empid}'/>"   name="empcode"/>
		</div>
		<label for="inlineFormCheck" class="form-check-label">Employee Email:</label>
		<div class="col-lg-6" >
 		
		<input class="form-control form-control-sm" type="Email" value="<e:out value='${Empdetails.empemail}'/>" name="empemail" />
		</div>
		</div>
		
		<div class=" form-group row">
		<label for="inlineFormCheck" class="form-check-label"> First Name:</label>
		<div class="col-lg-2" >
		
		<input class="form-control form-control-sm"  type="text" value="<e:out value='${Empdetails.empfname}'/>"  name="empfname" /><br><br>
		</div>
		<label for="inlineFormCheck" class="form-check-label"> Middle Name:</label>
		<div class="col-lg-2" >
		
		<input class="form-control form-control-sm" type="text" value="<e:out value='${Empdetails.empmname}'/>"  name="empmname" /><br><br>
		</div>
		<label for="inlineFormCheck" class="form-check-label"> Last Name:</label>
		<div class="col-lg-2" >
		
		<input class="form-control form-control-sm" type="text" value="<e:out value='${Empdetails.emplname}'/>"  name="emplname" /><br><br>
		</div>
		</div>
		<label for="inlineFormCheck" class="form-check-label">
		Employee Department<%-- <input type="text" value="<e:out value='${Empdetails.empdepartment}'/>"  name="empdepartment" /> --%>
		 </label> 
		  <select name="empdepartment" class="form-control form-select-lg mb-3 center" style="height:32px;  " required >
  			<option selected="selected" disabled="disabled" value="${Empdetails.empdepartment}">${Empdetails.empdepartment}</option>
 			<%for(Object departmentnname:department){ %>
  			<option  value="<%=departmentnname%>"><%=departmentnname%></option>
  			<% } %>
 		 </select>
		<br><br>
		<label for="inlineFormCheck" class="form-check-label">
		Employee Designation<%-- <input type="text" value="<e:out value='${Empdetails.empdesignation}'/>" name="empdesignation" /> --%>
		</label>
		<select name="empdesignation" class="form-control form-select-lg mb-3 center" style="height:32px;  " required >
  			<option selected="selected" disabled="disabled" value="${Empdetails.empdesignation}">${Empdetails.empdesignation}</option>
 			<%for(Object designationname:designation){ %>
  			<option  value="<%=designationname%>"><%=designationname%></option>
  			<% } %>
  	 	</select>  
		<br><br>
		<label for="inlineFormCheck" class="form-check-label">
		Employee Location<%-- <input type="text" value="<e:out value='${Empdetails.emplocation}'/>" name="emplocation"  /> --%>
		</label>
		<select name="emplocation" class="form-control form-select-lg mb-3 center" style="height:32px; " required >
 			 <option selected="selected" disabled="disabled" value="${Empdetails.emplocation}">${Empdetails.emplocation}</option>
 			<%for(Object locationame:location){ %>
  			<option  value="<%=locationame%>"><%=locationame%></option>
  			<% } %>
 		 </select>
		<br><br>
		
		<input type="hidden" name="actionType" value="Updateemp">
		<input type="submit" value="Save" class="button btn-success">
	</e:forEach>
	
	</form>
</e:if>

<e:if test="${ empty Employee}">
	<e:redirect url="Login.jsp"></e:redirect>
</e:if>
</body>

</html>