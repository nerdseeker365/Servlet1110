package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCitiesServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int countryCode=0;
		 String countries[]=new String[]{"india","pakistan","china","Austrilia","USA"};
		 String capitals[]=new String []{"New Delhi","Islmabad","Bejing","canBerra","WastingtonDC"};
		 
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 countryCode=Integer.parseInt(req.getParameter("country"));
		 //display capital
		 pw.println("<h1> Country name::"+countries[countryCode]+"</h1>");
		 pw.println("<h1> Capital name:: "+capitals[countryCode]+"</h1>");
		 //add hyperlink
		 pw.println("<a href='input.html'>home</a>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)

}//class
