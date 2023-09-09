package com.raghav.access;
import java.io.IOException;  
import java.io.*;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/SendMail")
public class SendMail extends HttpServlet {  
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		 String email = request.getParameter("email");
		 String table = request.getParameter("table");
		
		 Student ob  = new Student(email);
		 
	     String pass = getPassword(ob,table);
	     
	     if(pass != null)
	     {
	    	ob.setPassword(pass);
	    	Mail.sendPassword(ob);
	     }
	     else
	     {
	    	 String msg1 = "Invalid Email Address";
			 response.sendRedirect("forgot1.jsp?msg="+msg1);
	     }
		
		 
	}
    public static String getPassword(Student ob,String table) {
		
		String password = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = DriverManager
	            .getConnection("jdbc:mysql://localhost:3380/login?useSSL=false", "root", "raghavgarg12@");
		
		    String sql = "Select password from "+table+" where email=?";
		    
		    PreparedStatement stmt = con.prepareStatement(sql);
		    
		    stmt.setString(1, ob.getEmail());
		    
		    ResultSet rs = stmt.executeQuery();
		    
		    if(rs.next()) {
		    	password = rs.getString("password");
		    }
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return password;
	}

  
}  

