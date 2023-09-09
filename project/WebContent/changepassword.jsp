<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@ page import= "com.raghav.login.LoginClass" %>
<%
String currentPassword=request.getParameter("current");
String Newpass=request.getParameter("new");
String conpass=request.getParameter("confirm");
String connurl = "jdbc:mysql://localhost:3380/login?useSSL=false";
Connection con=null;
String pass="";
int id=0;
try{
	LoginClass obj= (LoginClass)session.getAttribute("obj");
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(connurl, "root", "raghavgarg12@");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from "+obj.getTable()+" where password='"+currentPassword+"'");
while(rs.next()){
id=rs.getInt(1);
pass=rs.getString(4);
} System.out.println(id+ " "+pass);
if(pass.equals(currentPassword)){
Statement st1=con.createStatement();
int i=st1.executeUpdate("update "+obj.getTable()+" set password='"+Newpass+"' where userId='"+id+"'");
out.println("Password changed successfully");
st1.close();
con.close();
}
else{
out.println("Invalid Current Password");
}
}
catch(Exception e){
out.println(e);
}
%>