package com.raghav.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raghav.registration.StudentDao;
import com.raghav.registration.Employee;



@WebServlet("/register")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao StudentDao;
	private TeacherDao StudentDao1;
	
	public void init() {
		StudentDao = new StudentDao();
		StudentDao1 = new TeacherDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userID = request.getParameter("userID");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String stream = request.getParameter("stream");
		String martial_status=request.getParameter("martial_status");
		String table = request.getParameter("table");
		
		Employee employee = new Employee();
		employee.setUserID(userID);
		employee.setUsername(username);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		employee.setStream(stream);
		employee.setMartial_status(martial_status);
		employee.setTable(table);
		
		try {
			if(stream!="") {
			StudentDao.registerStudent(employee);
			}else {
				StudentDao1.registerteacher(employee);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("employeedetails.jsp");
	}
}

