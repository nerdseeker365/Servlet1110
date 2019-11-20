package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String ss=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 ss=req.getParameter("ss");
		 //add hyperlink google search comp url
 pw.println("<a href='https://www.google.com/search?q="+ss+"'>"
  + " <h1 style='color:red;text-align:center'>Click here Go to google </h1></a>");
		 //close stream 
		 pw.close();
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
