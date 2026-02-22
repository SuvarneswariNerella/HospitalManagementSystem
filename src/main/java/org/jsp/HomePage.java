package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		pr.println("<h1>Home Page</h1>");
		pr.println("<a href=\"AddPatient.html\"><button>AddPatient</button></a><br><br>\r\n"
				+ " 	<a href=\"RemovePatient.html\"><button>RemovePatient</button></a><br><br>\r\n"
				+ " 	<a href=\"displayall\"><button>DisplayAll</button></a>");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
