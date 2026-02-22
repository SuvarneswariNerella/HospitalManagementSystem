package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPatient extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		long number = Long.parseLong(req.getParameter("number"));
		String email = req.getParameter("email");
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","root");
				PreparedStatement ps= con.prepareStatement("insert into patient values(?,?,?,?,?)");
				ps.setLong(1, id);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setLong(4, number);
				ps.setString(5, email);
				int res = ps.executeUpdate();
				if(res==1)
				{
					out.println("<h1>Patient Details Inserted Successfully</h1>");
				}
				else {
					out.println("<h1>Unsuccessful Insertion</h1>");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		
		
	}
}
