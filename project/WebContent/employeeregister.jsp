<!DOCTYPE html>
<html>
<head>
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
	top: 15%;
	background-color: MediumSeaGreen;
	color: white;
	box-sizing:border-box;	
	border: 1px solid black;
	border-radius: 2px;
	box-shadow: 2px 4px 8px 0 rgba(0, 0, 0, 0.3);
	padding: 10px 20px;
    height: 450px;
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
  <h1>Employee Register Form</h1>
  <form action="register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Roll No</td>
     <td><input type="text" name="userID" /></td>
    </tr>
    <tr>
     <td>Username</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Phone</td>
     <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
     <td>Stream</td>
     <td><input type="text" name="stream" /></td>
    </tr>
    <tr>
     <td>Martial_Status</td>
     <td><input type="text" name="martial_status" /></td>
    </tr>
   </table>
   Login as
   
                        <input type="radio" name="table" value="student">Student
   
                        <input type="radio" name="table" value="teacher">Teacher
   
				 <br><br>
   
   <input type="submit" value="Submit" />
   <br><br>
   <div id="footer2">
		<p><a href="login.jsp">Login</a></p>			
	</div>
  </form>
 </div>
 </div>
</body>
</html>
