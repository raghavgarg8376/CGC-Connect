<%@ page import="java.sql.*" %>
<%@ page import="com.raghav.access.Mail" %>
<%@page import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<%
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3380/login?useSSL=false","root","raghavgarg12@");
Statement st=con.createStatement();
String email=request.getParameter("email");
String table=request.getParameter("table");
String strQuery = "SELECT password FROM "+table+" where email='"+email+"'";
System.out.println(strQuery+" ");
ResultSet rs = st.executeQuery(strQuery);

rs.next();
String Countrow = rs.getString(1);
System.out.println(rs.getString("password"));
if(Countrow.equals("1")){
	
/*mail code
paste your mail code here
------------------
Mail code*/
String to=email;  
String password=rs.getString("password");
String subject="change password";  
System.out.println(to+" "+password+" "+subject);
      
Mail.send(to, subject, password);

out.println("Password send to your email id successfully !");
}
else{
out.println("Invalid Email Id !");
}
}
catch (Exception e){
e.printStackTrace();
}
%>
</body>
</html>