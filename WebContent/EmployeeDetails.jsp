<%@page import="java.util.List"%>
<%@page import="com.rahul.employee.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="e"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">



<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<link href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Page level plugin JavaScript--><script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>

<script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>

<title>Update EmployeeData.</title>
<style type="text/css">
.edit {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 5px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 2px 1px;
  cursor: pointer;
}
.delete {
  background-color: #f44336; /* Green */
  border: none;
  color: white;
  padding: 5px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 2px 1px;
  cursor: pointer;
}
</style>
</head>
<body>
<%List role= new EmployeeDAO().getRoles(); 
//System.out.print(role);
%>
<jsp:include page="Header.jsp"></jsp:include>
<e:if test="${not empty Employee}">
<e:set var="msg" value="" scope="session" />
<div>

</div>
<div class="container form" style=" padding-top: 20px">
<e:if test="${not empty msg}">

<a class="alert-info ">
<e:out value='${requestScope["msg"] }'></e:out>
</a>
</e:if>
	<table class="table  table-striped table-bordered" id="dataTable" >
	<thead style="text-align: center;">
		<tr>
			<td><strong>Sr.No</strong></td>
			<td><strong>Employee Id</strong></td>
			<td><strong>Employee Name</strong></td>
			<td><strong>Employee Designation</strong></td>
			<td><strong>Employee Location</strong></td>
			<td><strong>Employee Department</strong></td>
			<e:if test="${sessionScope.Employee.emprole== 'ADMIN'}">
				<td><strong>Action</strong></td>
			</e:if>
			<e:if test="${sessionScope.Employee.emprole== 'SUPERADMIN'}">
				<td><strong>Role</strong></td>
				<td><strong>Action</strong></td>
			</e:if>
		</tr>
	</thead>
	<tbody style="text-align: center">
		<e:set value="1"  var="i"></e:set>
		<e:set var="role" value='${requestScope["role"]}' />
		<e:forEach items="${emplist}" var="EmployeeData" >
		<tr>
			<td>${i}.</td>
			<td class="gfgusername">${EmployeeData.empid}</td>
			<td >${EmployeeData.empfname} ${EmployeeData.emplname}</td>
			<td>${EmployeeData.empdesignation}</td>
			<td>${EmployeeData.emplocation}</td>
			<td>${EmployeeData.empdepartment}</td>
			<e:if test="${sessionScope.Employee.emprole== 'ADMIN'}">
				<td><a class="edit nav-link" href="CRUD?actionType=Editemp&&empid=${EmployeeData.empid}"/>Edit</a>
				<a class="delete nav-link" href="CRUD?actionType=Deleteemp&&empid=${EmployeeData.empid}"/>Delete</a></td>
			</e:if>
			<e:if test="${sessionScope.Employee.emprole== 'SUPERADMIN'}">
				<td contenteditable="true" onclick="changeRole()" id="role" class="gfgpp" value="${EmployeeData.emprole}">${EmployeeData.emprole}</td>
				<td><a class="edit nav-link gfgselect" data-toggle="modal" data-target="#gfgmodal" />Update</a></td>
			</e:if>
			
		</tr>
		<e:set value="${i+1}"  var="i"></e:set>
		</e:forEach>
	</tbody>
	</table>
</div>
	</e:if>
	<e:if test="${ empty Employee}">
		<e:redirect url="Login.jsp"></e:redirect>
	</e:if>	

</body>
<div class="modal fade" id="gfgmodal" tabindex="-1" role="dialog"> 
            <div class="modal-dialog"> 
                <div class="modal-content"> 
                    <div class="modal-header"> 
                        <!-- MODEL TITLE -->
                        <h2 class="modal-title"
                            id="gfgmodallabel"> 
                          Selected row</h2> 
                        <button type="button"  class="close"  data-dismiss="modal"   aria-label="Close"> 
                            <span aria-hidden="true"> 
                              ×
                            </span> 
                        </button> 
                    </div> 
                    <!-- MODEL BODY -->
                    <div class="modal-body"> 
                        <div class="GFGclass"   id="divGFG">
                             <input type="hidden" name="Roleupdate" value="Role">
                        </div> 
                        <div class="modal-footer"> 
         <!-- The close button in the bottom of the modal -->
         <button type="button" id="submit" class="btn btn-success"  data-dismiss="modal"> 
                              Change role</button> 
                            <button type="button"
                                    class="btn btn-secondary" 
                                    data-dismiss="modal"> 
                              Close</button> 
                        </div> 
                    </div> 
                </div> 
            </div> 
            </div>
            
<script> 
            $(function () { 
                // ON SELECTING ROW 
                $(".gfgselect").click(function () { 
                
   //FINDING ELEMENTS OF ROWS AND STORING THEM IN VARIABLES 
                    var empid =  $(this).parents("tr").find(".gfgusername").text(); 
                    var emprole =$(this).parents("tr").find(".gfgpp").text(); 
                   
                    var p = ""; 
                    // CREATING DATA TO SHOW ON MODEL 
                     p +=  
              "<p><b> Employee ID and Current role:</b> </p>"; 
                    p +=  
              "<p id='empid' name='empid'  >"+empid+"</p>"; 
                    
                    p += 
              "<p id='emprole' name='emprole'> "  
                      +emprole+ "</p>"; 
                 
                      p += 
              "<p><b>Update role to:</b></p>"+"<select id='updaterole'>"+
              "<option value='SUPERADMIN' >SUPERADMIN</option>"+
              "<option value='ADMIN'>ADMIN</option>"+
              "<option value='USER'>USER</option>"+"</select>"; 
             
             
                      
                    //CLEARING THE PREFILLED DATA 
                    $("#divGFG").empty(); 
                    //WRITING THE DATA ON MODEL 
                    $("#divGFG").append(p); 
                }); 
            }); 
            
            $('button#submit').click(function(e){
          		var empid= document.getElementById("empid").innerHTML;
          		var emprole= document.getElementById("updaterole").value;
          		
   				 $.ajax({
   				 
       			 url: 'CRUD',
       			 type: 'POST',
       			 data: 
       			 {
       			  empid:empid,
               	  emprole:emprole,
               	  actionType:"Role"
              	 },
       			 success: function(response) {
            		alert(response);
            		url="http://localhost:8080/ManageEmployee/CRUD?actionType=Emplist"
            		 window.location=url; 
            		
        		},
       			 error: function(msg) {
            	alert("Something went wrong..");
      		  }	
     		 });
   			 
});
        </script> 

</html>