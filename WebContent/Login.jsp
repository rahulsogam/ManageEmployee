
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="e"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<style type="text/css">
.imgcontainer {
  text-align: center;
  margin: 14px 10px 40px 10px;
  position: relative;
}

img.avatar {
  width: 30%;

  border-radius: 50%;
}
</style>
<title>Login</title>
</head>
<body class="" style="background-image: url('images/background-images-for-login-form-8.jpg');" >
<div class=" col-sm-6" >
	<form action="Login" method="post" autocomplete="off" class="clearfix hidden-sm  container"  style="background: #00000005;padding-top: 125px;"  >
		
		<div class="row justify-content-center" style="padding-top: 65px;">
      	<img src="images/login.png" alt="Avatar" class="avatar">
   	    </div>
		
		<div class="row justify-content-center" style="padding-top: 65px;">
		<input type="text" name="Empid" placeholder="Employee Id" required="required">
		</div>
		<br>
		<br>
		<div class="row justify-content-center">
		<input type="password" name="Emppass" placeholder="Password" required="required">
		</div>
		<br>
		<br>
		<div class="row justify-content-center">
		<input type="submit" value="Login" class="btn-success">
		</div>
		<br>
		<br>
		
		<e:if test="${not empty msg}">
				<div
					class="toast d-flex align-items-center text-white bg-primary border-0"
					role="alert" aria-live="assertive" aria-atomic="true">
					<div class="toast-body"><e:out value="${msg}" /></div>
					<button type="button"
						class="btn-close btn-close-white ms-auto me-2"
						data-bs-dismiss="toast" aria-label="Close"></button>
				</div>
				<%-- <div class="alert alert-danger alert-dismissible fade show" role="alert">
			<strong style="align-content: center; "><e:out value="${msg}" /></strong>
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		</div> --%>
		<e:set var="msg" value="" scope="request" />
	</e:if>
	</form>
</div>
</body>
</html>