package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addurl")
public class AddServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	     System.out.println("AddServlet.init(-)");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("AddServlet::doGet(-,-)");
		PrintWriter pw=null;
		int val1=0,val2=0;
		int sum=0;
		//general settings
		res.setContentType("text/html");
		pw=res.getWriter();
		//read form data
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
		//perform addition
		sum=val1+val2;
		//display result
		pw.println("<h1>AddServlet -->The Sum is ::"+sum +"</h1>");
		//add hyperlink
		pw.println("<a href='input.html'>home</a>");
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
		
	}
	
	@Override
	public void destroy() {
	   System.out.println("AddServlet.destroy()");
	}

}
