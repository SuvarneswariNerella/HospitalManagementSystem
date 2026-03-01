package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayAll extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","root");
			PreparedStatement ps = con.prepareStatement("select * from patient");
			PrintWriter pr = resp.getWriter();
			//System.out.println("Working");
			pr.println("<h1>All Patient Records</h1>");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				long number = rs.getLong("number");
				String email = rs.getString("email");
				
				pr.println("<h3>"+id+"  "+name+"  "+address+"  "+number+" "+email+"</h3>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
