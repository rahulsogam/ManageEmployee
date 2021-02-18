<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<body>
	
	<jsp:include page="Header.jsp"></jsp:include>

	<e:if test="${not empty Employee}">
	<e:set var="msg" value="" scope="session" />
	<div class="container "  style="padding-top: 30px">
	<table class="table  table-striped table-bordered"  >
		<thead style="text-align: center;">
			<tr>
				<th colspan="2" style="text-align: center;"><strong >Self Details</strong></th>
			</tr>
	</thead>
	<tbody style="text-align: center">
			
			
			<tr>
			<td>Name</td>
			<td>${sessionScope.Employee.empfname} ${sessionScope.Employee.empmname} ${sessionScope.Employee.emplname}</td>
			</tr>
			<tr>
			<td>Employee Id</td>
			<td>${sessionScope.Employee.empid}</td>
			</tr>
			<tr>
			<td>Employee Birthdate</td>
			<td>${sessionScope.Employee.empbirthdate}</td>
			</tr>
			<tr>
			<td>Employee Contact</td>
			<td>${sessionScope.Employee.empcontact}</td>
			</tr>
			<tr>
			<td>Employee Address</td>
			<td>${sessionScope.Employee.empaddress}</td>
			</tr>
			<tr>
			<td>Employee Location</td>
			<td>${sessionScope.Employee.emplocation}</td>
			</tr>
			<tr>
			<td>Employee Department</td>
			<td>${sessionScope.Employee.empdepartment}</td>
			</tr>
			<tr>
			<td>Employee Designation</td>
			<td>${sessionScope.Employee.empdesignation}</td>
			</tr>
			<tr>
			<td>Employee Mail</td>
			<td>${sessionScope.Employee.empemail}</td>
			</tr>
			
			<tr>
			<td>Employee Joindate</td>
			<td>${sessionScope.Employee.empjoindate}</td>
			</tr>
			
			
		
	</tbody>
	</table>
		</div>
	
	</e:if>
	<e:if test="${ empty Employee}">
		<e:redirect url="Login.jsp"></e:redirect>
	</e:if>
	

</body>

</html>