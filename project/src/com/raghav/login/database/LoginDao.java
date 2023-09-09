package com.raghav.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.raghav.login.LoginClass;
public class LoginDao{
	
	Connection connection ;
	public LoginDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3380/login?useSSL=false", "root", "raghavgarg12@");

	}
	
	public boolean validate(LoginClass loginClass) throws SQLException {
		boolean status = false;
		String h=loginClass.getTable();
		String m="select * from "+h+" where userID=? and password =?";


		
		
		// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(m);
				preparedStatement.setString(1, loginClass.getUserID());
					preparedStatement.setString(2, loginClass.getPassword());

					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
					status = rs.next();
					
				
				return status;
			}
		  
		}
