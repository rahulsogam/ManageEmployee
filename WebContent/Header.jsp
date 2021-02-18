<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>EMS</title>
<style type="text/css">
.button {
    display: block;
    width: 115px;
    height: 40px;
    background: #226e92;
    padding: 3px;
    text-align: center;
    border-radius: 29px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}

.Logout {
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

<e:if test="${Employee.emprole== 'USER'}">
	<nav>
			<ul class="nav nav-tabs mr-auto ">
  <li class="nav-item">
    <a class="nav-link button" aria-current="page" href="Main.jsp">Home</a>
  </li>
 
	<li class="nav-item "  >
	<a href="Logout" class="nav-link button Logout">Logout </a>
	</li>
</ul>
			
	</nav>
</e:if>
<e:if test="${Employee.emprole== 'ADMIN'}">

<ul class="nav nav-tabs mr-auto ">
  <li class="nav-item">
    <a class="nav-link button" aria-current="page" href="Main.jsp">Home</a>
  </li>
  <li class="nav-item ">
    <a class="nav-link button" aria-current="page" href="AddEmployee.jsp">Add</a>
  </li>
  <li class="nav-item">
    <a href="CRUD?actionType=Emplist" class="nav-link button">Update </a>
  </li>
	<li class="nav-item "  >
	<a href="Logout" class="nav-link button Logout">Logout </a>
	</li>
</ul>
 
	</e:if>
	
	<e:if test="${Employee.emprole== 'SUPERADMIN'}">

<ul class="nav nav-tabs mr-auto ">
  <li class="nav-item">
    <a class="nav-link button" aria-current="page" href="Main.jsp">Home</a>
  </li>
  <li class="nav-item ">
    <a class="nav-link button" aria-current="page" href="CRUD?actionType=Emplist">ChangeRole</a>
  </li>
  <li class="nav-item">
    <a href="CRUD?actionType=Lock" class="nav-link button">Lock Id </a>
  </li>
	<li class="nav-item "  >
	<a href="Logout" class="nav-link button Logout">Logout </a>
	</li>
</ul>
</e:if>


</body>
</html>