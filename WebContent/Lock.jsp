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
			<td><strong>Lock</strong></td>
			<td><strong>Action</strong></td>
		</tr>
	</thead>
	<tbody style="text-align: center">
		<e:set value="1"  var="i"></e:set>
		<e:set var="role" value='${requestScope["role"]}' />
		<e:forEach items="${EmpData}" var="EmployeeData" >
		<tr>
			<td>${i}.</td>
			<td class="gfgusername">${EmployeeData.empid}</td>
			<td >${EmployeeData.empfname} ${EmployeeData.emplname}</td>
			<td>${EmployeeData.empdesignation}</td>
			<td>${EmployeeData.emplocation}</td>
			<td>${EmployeeData.empdepartment}</td>
			<td >${EmployeeData.emplock}</td>
			<e:if test="${EmployeeData.emplock== 'No'}">
			<td class="gfgpp" value="Yes" ><a class="edit nav-link bg-danger  gfgselect"  value="Yes" data-toggle="modal" data-target="#gfgmodal"/>Lock</a></td>
			</e:if>
			<e:if test="${EmployeeData.emplock== 'Yes'}">
				<td class="gfgpp" value="No"><a class="edit nav-link  gfgselect"  value="No" data-toggle="modal" data-target="#gfgmodal"/>Unlock</a></td>
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
                              Update</button> 
                            <button type="button"
                                    class="btn btn-secondary" 
                                    data-dismiss="modal"> 
                              Close</button> 
                        </div> 
                    </div> 
                </div> 
            </div> 
            </div>
</body>

 <script type="text/javascript">
 $(function () { 
                // ON SELECTING ROW 
                $(".gfgselect").click(function () { 
                
   //FINDING ELEMENTS OF ROWS AND STORING THEM IN VARIABLES 
                    var empid =  $(this).parents("tr").find(".gfgusername").text(); 
                    var status =$(this).parents("tr").find(".gfgpp").text(); 
                   
                    var p = ""; 
                    // CREATING DATA TO SHOW ON MODEL 
                     p +=  
              "<p><b> Employee ID :</b> </p>"; 
                    p +=  
              "<p id='empid' name='empid'  >"+empid+"</p>"; 
                    
                    p += 
                     "<p><b> Update Status to  :</b> </P>";
                     p+=
                     "<p id='update' name='emprole'>"+status+ "</p>"; 
                 
                    //CLEARING THE PREFILLED DATA 
                    $("#divGFG").empty(); 
                    //WRITING THE DATA ON MODEL 
                    $("#divGFG").append(p); 
                }); 
            }); 
            
            $('button#submit').click(function(e){
          		var empid= document.getElementById("empid").innerHTML;
          		var status=document.getElementById("update").innerHTML; 
          		if(status=="Lock")
          		{
          			status="Yes";
          		}
          		else
          		{
          			status='No';
          		}
   				 $.ajax({
   				 
       			 url: 'CRUD',
       			 type: 'POST',
       			 data: 
       			 {
       			  empid:empid,
               	  status:status,
               	  actionType:"lock"
              	 },
       			 success: function(response) {
            		alert(response);
            		url="http://localhost:8080/ManageEmployee/CRUD?actionType=Lock";
            		 window.location=url; 
            		
        		},
       			 error: function(msg) {
            	alert("Something went wrong..");
      		  }	
     		 });
   			 
});
        </script>           
<script> 
         function Lock(){
            var c=confirm("You sure you want to perform this action.!");
            var update=document.getElementsById("update").getAttribute("value");
            var empid=document.getElementById("empid").value;

            alert(update);
            /* if(c==true)
            {
          		 $.ajax({
   				 
       			 url: 'CRUD',
       			 type: 'POST',
       			 data: 
       			 {
       			  update:update,
       			  empid:empid,
               	  actionType:"lock"
              	 },
       			 success: function(response) {
            		alert(response);
            		url="http://localhost:8080/ManageEmployee/CRUD"
            		 window.location=url; 
            		
        		},
       			 error: function(msg) {
            	alert("Something went wrong..");
            	}	
     		 });
     		 }url="http://localhost:8080/ManageEmployee/CRUD"
            		 window.location=url;  */
   			 
}
        </script> 

</html>