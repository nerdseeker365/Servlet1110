package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("req obj class name::"+req.getClass()+" res obj class name::"+res.getClass());
	    PrintWriter pw=null;
	    String uname=null,pwd=null;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form data
	    uname=req.getParameter("t1");
	    pwd=req.getParameter("t2");
	    //perform authtentication
	    if(uname.equalsIgnoreCase("raja@gmail.com") && pwd.equalsIgnoreCase("rani")) 
	    	pw.println("<h1 style='color:red;text-align:center'> Valid Credentials </h1>");
    	else
    		pw.println("<h1 style='color:red;text-align:center'> InValid Credentials </h1>");
	    
	    pw.println("<br> details are ::"+uname+"..."+pwd);
	    
	    //add hyperlink
	    pw.println("<br><a href='login.html'>home</a>");
	    
	    //close stream
	    pw.close();
	    }
	    
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}//class
