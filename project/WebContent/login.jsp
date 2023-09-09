<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	min-width: 1080px;
	min-height: 600px;
}
.city {
  background-color: steelblue;
  color: white;
  border: 2px solid black;
  margin: 20px;
  padding: 20px;
}
fieldset{
	border: 2px solid grey;
	border-radius:2px;
	padding:20px;
	
}
div#loginBox {	
	position:relative;
	top: 25%;
	background-color: steelblue;
	color: white;
	box-sizing:border-box;	
	border: 1px solid black;
	border-radius: 2px;
	box-shadow: 2px 4px 8px 0 rgba(0, 0, 0, 0.3);
	padding: 10px 20px;
    height: 400px;
    width:500px;
        
}
div#footer2 {
	background-color:lightgrey;
	font-family: Verdana,sans-serif;
	border: .5px solid whitesmoke;
	border-radius:2px;
	padding: 10px 20px;
	max-height:auto;
	max-width:auto;
	tab-size: 20;
}
div#container {
	position:relative;
	overflow:hidden;
    background-image: url('dottedbg.png');
    background-size: 100% 100%;
    height:100%;
    width:100%;
	display:flex;
	justify-content:center;
	
}
input.theinput{
	font-family: Verdana,sans-serif;
	color:black;
	boxsizing: border-box;
	border:1px solid grey;
	border-radius:4px;
	padding: 5px 10px;
}
input.submit {
	background-color: grey;
	padding: 5px 10px;
	color: white;
	display: inline:block;
	border-radius:4px;
	border: 1px solid whitesmoke;
	transition-duration:0.4s;
}


</style>
</head>
<body>
    <div id="container">
	    <div align="center" id="loginBox">
		    <h1>Login</h1>
		    <form action="loginServlet" method="post">
		        <fieldset style= "margin:auto text-align:center">
		        
			    <table style="with: 90%">
				    <tr>
					    <td>UrName</td>
					    <td><input type="text" class="theinput" placeholder="Enter UserId" name="userID" required/></td>
				    </tr>
				    <tr>
					    <td>Password</td>
					    <td><input type="password" class="theinput" placeholder = "Enter password" name="password" required/></td>
				    </tr>
			    </table>
			    
				Login as
   
                        <input type="radio" name="table" value="student">Student
   
                        <input type="radio" name="table" value="teacher">Teacher
   
                        <input type="radio" name="table" value="admin">Admin
				 <br>
			    <input class="submit" type="submit" value="Submit" /><br>
			    </fieldset>
			    <br>
			    <div id="footer2">
			    <a href="forgot1.jsp" style="color:Solid Tomato;" >Forgot Password?</a>
			    <a href="index.jsp" style="color:Solid Tomato;" >Home Page</a>
			    </div>
		    </form>
	     </div>
	</div>
	
</body>
</html>