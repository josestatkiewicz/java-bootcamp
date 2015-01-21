package ar.com.ignacioflores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloNameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		HelloNameService helloNameService = new HelloNameService();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println(" 		<link rel='stylesheet' href='./css/topic2.css' type='text/css' />");
		pw.println("		<TITLE>Servlet Maven</TITLE>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<div id='container'>");
		pw.println("			<header>");
		pw.println("				My test webApp using Maven");
		pw.println("			</header>");
		pw.println("			<div id='wrapper'>");
		pw.println(helloNameService.welcome("ignacio"));
		pw.println("			</div>");
		pw.println("			<footer>");
		pw.println("			</footer>");
		pw.println("		</container>");
		pw.println("	</body>");
		pw.println("</html>");
		pw.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doGet(request,response);
	}	
}
