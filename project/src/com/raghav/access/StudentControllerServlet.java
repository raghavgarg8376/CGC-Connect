package com.raghav.access;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.raghav.registration.Employee;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;
	Employee employee = new Employee();
	@Override
	public void init() throws ServletException {
		
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil();
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// list the students ... in mvc fashion
		String theCommand = request.getParameter("command");
		
		if(theCommand == null) {
			theCommand = "/list";
		}
		try {
			switch (theCommand) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
				
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listUser = studentDbUtil.selectAllUsers();
		request.setAttribute("STUDENT_LIST", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userId"));
		Student existingUser = studentDbUtil.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-form.jsp");
		request.setAttribute("STUDENT_LIST", existingUser);
		System.out.println(id);
		
		employee.setUserID(request.getParameter("userId"));
		dispatcher.forward(request, response);

	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userid=Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password=request.getParameter("password");
		String country = request.getParameter("phone");
		Student newUser = new Student(userid,name, email,password, country);
		studentDbUtil.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int id = Integer.parseInt(employee.getUserID());
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String country = request.getParameter("phone");

		Student book = new Student(id, name, email, country);
		studentDbUtil.updateUser(book);
		try {
			listUser(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
	{
		try {
		int id = Integer.parseInt(request.getParameter("userId"));
		studentDbUtil.deleteUser(id);
		}
		catch (Exception e) {
            System.out.println("Can't delete data from database" + e.getMessage());
        }
		try {
			listUser(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}







