package com.raghav.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private String jdbcURL = "jdbc:mysql://localhost:3380/login?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "raghavgarg12@";
	private static final String INSERT_USERS_SQL = "INSERT INTO student" + "  (userId,username, email,password, phone) VALUES "
			+ " (?,?,?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select userId,username,email,phone from student where userId =?";
	private static final String DELETE_USERS_SQL = "delete from student where userID = ?;";
	private static final String SELECT_ALL_USERS = "select * from student";
	private static final String UPDATE_USERS_SQL = "update student set username = ?,email= ?, phone =? where userId = ?"; // 4 ? hai to 4 hi set krne hai 
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public void insertUser(Student user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getPhone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Student selectUser(int id) {
		Student user = null;
		
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
				
		    // Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int iid=rs.getInt("userId");
				String name = rs.getString("username");
				String email = rs.getString("email");
				String country = rs.getString("phone");
				user = new Student(iid, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	public List<Student> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Student> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("userId");
				String name = rs.getString("username");
				String email = rs.getString("email");
				String country = rs.getString("phone");
				users.add(new Student(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted=false;
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);
			statement.executeUpdate();
			rowDeleted=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public boolean updateUser(Student user) throws SQLException {
		boolean rowUpdated=false;
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL); 
			System.out.println("updated User:"+statement);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPhone());
			statement.setInt(4, user.getUserId()); // id String hai ya int int
		    statement.executeUpdate();
		    rowUpdated=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
		// at the time of updating u have to give the userId in that form ok
		//run now
		//
		
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}





