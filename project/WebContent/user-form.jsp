<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				

				<form action="StudentControllerServlet" method="GET">

                    <input type="hidden" name="command" value="/update" >
				    <c:if test="${user != null}">
					     <input type="hidden" name="userId" value="<c:out value='${STUDENT_LIST.userId}' />" />
				    </c:if>
				
				    <fieldset class="form-group">
					    <label>User Name</label> <input type="text"
						    value="<c:out value='${STUDENT_LIST.username}' />" class="form-control"
						    name="username" required="required">
				    </fieldset>

				    <fieldset class="form-group">
					    <label>User Email</label> <input type="text"
						    value="<c:out value='${STUDENT_LIST.email}' />" class="form-control"
						    name="email">
				    </fieldset>

				    <fieldset class="form-group">
					    <label>User Phone_No</label> <input type="text"
						    value="<c:out value='${STUDENT_LIST.phone}' />" class="form-control"
						    name="phone">
				    </fieldset>

				    <button type="submit" class="btn btn-success">Save</button>
				</form>
				<div style="clear: both;"></div>
		
		        <p>
			         <a href="StudentControllerServlet">Back to List</a>
		        </p>
			</div>
		</div>
	</div>
</body>
</html>
