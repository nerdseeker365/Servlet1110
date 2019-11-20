package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //general settings
		PrintWriter pw=null;
		res.setContentType("text/html");
		ServletConfig cg=null;
		//get PrintWriter 
		pw=res.getWriter();
		//get SErvletconfig obj
		cg=getServletConfig();
		pw.println("dbuser init param value ::"+cg.getInitParameter("dbuser"));
		pw.println("<br>p1 init param value ::"+cg.getInitParameter("p1"));
		//close stream
		pw.close();
		}
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}
}//class
