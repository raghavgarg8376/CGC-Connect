<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Database</title>
	
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Student-List </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="Logout"
					class="nav-link">LogOut</a></li>
			</ul>
		</nav>
	</header>
	<br>

    <div class="row">
	    
	    <div class="container">
	        <h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="employeeregister.jsp" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
				
			<table class="table table-bordered">
			    <thead>
				    <tr>
					    <th>Roll No</th>
					    <th>Name</th>
					    <th>Email</th>
					    <th>Phone No</th>
					    <th> actions</th>
				    </tr>
				</thead>
				
				<tbody>
				
				    <c:forEach var="tempStudent" items="${STUDENT_LIST}">
					   
					    <!-- set up a link for each student -->
					<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="/edit" />
						<c:param name="userId" value="${tempStudent.userId}" />
					</c:url>

					    <!--  set up a link to delete a student -->
					    <c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="/delete" />
						<c:param name="userId" value="${tempStudent.userId}" />
					    </c:url>
					    
					    <tr>
						    <td> ${tempStudent.userId} </td>
						    <td> ${tempStudent.username} </td>
						    <td> ${tempStudent.email} </td>
						    <td> ${tempStudent.phone}</td>
						    <td><a href="${tempLink}">Update</a> 
								 |
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a></td>
					    </tr>
				
				    </c:forEach>
				 </tbody>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>
