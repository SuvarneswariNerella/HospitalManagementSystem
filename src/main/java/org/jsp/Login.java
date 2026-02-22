package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email = ?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			PrintWriter out = res.getWriter();
			if (resultSet.next()) {

				String dbpassword = resultSet.getString("password");
				if (dbpassword.equals(password)) {
					// move to the HomePage
					RequestDispatcher dispatcher = req.getRequestDispatcher("HomePage");
					dispatcher.forward(req, res);
				} else {
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
					out.println("<h1>Invalid Password</h1>");
					dispatcher.include(req, res);
				}

			} else {

				RequestDispatcher dispatcher1 = req.getRequestDispatcher("login.html");
				out.println("<h1>Invalid user</h1>");
				dispatcher1.include(req, res);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}














/*
 * public void service(ServletRequest req, ServletResponse res) throws
 * ServletException, IOException { //System.out.println("Login Successfull");
 * String email = req.getParameter("email"); String password =
 * req.getParameter("password"); try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection connection =
 * DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/a11","root","root"); PreparedStatement
 * preparedStatement = connection.
 * prepareStatement("SELECT * from a16 where email = ? AND  password=?");
 * preparedStatement.setString(1, email); preparedStatement.setString(2,
 * password); //ResultSet resultSet = preparedStatement.executeQuery();
 * //PrintWriter out = res.getWriter(); try (ResultSet resultSet =
 * preparedStatement.executeQuery(); PrintWriter out = res.getWriter()) {
 * 
 * if (resultSet.next()) { /*out.println("<h1>Login successful</h1>");
 * System.out.println("Login successful");
 */

/*
 * String dbname = resultSet.getString("name"); String dbemail =
 * resultSet.getString("email"); String dbpassword =
 * resultSet.getString("password"); String dbnumber =
 * resultSet.getString("number");
 * 
 * out.println("<h1>Name: </h1>");
 * out.println("<input type=text value="+dbname+">");
 * out.println("<h1>Email: </h1>");
 * out.println("<input type=email value="+dbemail+">");
 * out.println("<h1>Password: </h1>");
 * out.println("<input type=password value="+dbpassword+">");
 * out.println("<h1>Number: </h1>");
 * out.println("<input type=tel value="+dbnumber+"> <br>");
 * out.println("<button>Delete</button>");
 * out.println("<button>Update</button>");
 */

// move to the HomePage
/*
 * RequestDispatcher dispatcher = req.getRequestDispatcher("homepage");
 * dispatcher.forward(req, res);
 * 
 * } else { //out.println("<h1>Invalid email or password</h1>");
 * //System.out.println("Login unsuccessful"); RequestDispatcher dispatcher1 =
 * req.getRequestDispatcher("login.html");
 * out.println("<h1>Invalid user or Password</h1>"); dispatcher1.include(req,
 * res);
 * 
 * } }
 * 
 * } catch(Exception e) { e.printStackTrace(); } }
 * 
 */
