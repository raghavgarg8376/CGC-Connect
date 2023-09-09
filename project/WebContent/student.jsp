<%@page import="com.raghav.login.database.*"%>
<%@ page import= "com.raghav.login.LoginClass" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<style type="text/css">
	li
	{
		float: left;
	}
	ul
	{
	
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		background-color:#333; 
	}
	li a
	{
		display: inline-block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none; 
	}
	li a:HOVER {
	background-color: red;
}
</style>
<title>HOME</title>

</head>
<body >
	<ul>
		<li> <a href="index.jsp">HOME</a></li>
		<li> <a href="call.html">CHANGE PASSWORD</a></li>
		<li> <a href="Logout">LOGOUT</a></li>
		
		
	</ul>	
	
	<h1 Align="center"><%
	
	out.println("Hey! Student "+request.getParameter("userID")); %></h1>
	
	<h1><a href= "call1.jsp"><input type= "button" value= "View Personal Details"></a></h1>
	
</body>
</html>