<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import= "com.raghav.login.LoginClass" %>
<%
String id = request.getParameter("userID");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3380/login?useSSL=false";
String database = "test";
String userid = "root";
String password = "raghavgarg12@";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
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

<h1 style="background-color: skyBlue" Align="center">Details</h1>
<table border="1" Align="center">
<tr>
<td>UserId</td>
<td>Username</td>
<td>Email</td>
<td>Phone</td>


</tr>
<%
try{
	
	LoginClass obj= (LoginClass)session.getAttribute("obj");
	
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from "+obj.getTable()+" where userId='"+obj.getUserID()+"'";
resultSet = statement.executeQuery(sql);
System.out.println(request.getParameter("userID"));
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("userId") %></td>
<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("phone") %></td>

</tr>

<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>