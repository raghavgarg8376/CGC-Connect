
package com.raghav.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raghav.login.database.LoginDao;



@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

//	public void init() {
//		try {
//			//loginDao = new LoginDao();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("userID");
		String password = request.getParameter("password");
		String table = request.getParameter("table");
		
		LoginClass loginClass = new LoginClass();
		loginClass.setUserID(username);
		loginClass.setPassword(password);
		loginClass.setTable(table);
		
		HttpSession ses= request.getSession();
		ses.setAttribute("obj", loginClass);
				
		
		/*if(loginDao.validate(loginClass))

		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("student.jsp");
	dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("teacher.jsp");		
			dispatcher.forward(request, response);
			
		}*/
		try {
			loginDao = new  LoginDao();
			if (loginDao.validate(loginClass)) {
				String h=loginClass.getTable();
				RequestDispatcher dispatcher=request.getRequestDispatcher(h+".jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
