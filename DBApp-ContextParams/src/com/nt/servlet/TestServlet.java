package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		ServletContext sc=null;
		//get PrintWriter 
		pw=res.getWriter();
		//get SErvletconfig obj
		sc=getServletContext();
		pw.println("<br><b> server info:: "+sc.getServerInfo()+"</b>");
		pw.println("<br><b> server api version:: "+sc.getMajorVersion()+"."+sc.getMinorVersion()+"</b>");
		pw.println("<br><b> context path ::"+sc.getContextPath()+"</b>");
		pw.println("<br><b> path of input ::"+sc.getRealPath("/input.html")+"</b>");
		pw.println("<br><b> path of Web root folder ::"+sc.getRealPath("/")+"</b>");
		pw.println("MIME type of input.html"+sc.getMimeType("input.html"));
		sc.log("Hello, how are u? Good Morning::"+new Date());
		
				
		//close stream
		pw.close();
		}
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}
}//class
