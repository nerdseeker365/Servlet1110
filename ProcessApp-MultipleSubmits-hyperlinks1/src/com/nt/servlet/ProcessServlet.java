package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	   int val1=0,val2=0;
	   String pVal=null;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read s1 req param value
	    pVal=req.getParameter("source");
	    System.out.println(pVal);
	    //read form data  only when Buttons are used to submit the request
	    if(!pVal.equalsIgnoreCase("link1") && !pVal.equalsIgnoreCase("link2")) {
	    	val1=Integer.parseInt(req.getParameter("t1"));
	    	val2=Integer.parseInt(req.getParameter("t2"));
	    }
	    //write code for Buttons and hyperlinks
	    if(pVal.equalsIgnoreCase("link1")) {
	    	pw.println("<h1 style='color:red'>System Properties are </h1>");
	    	pw.println(System.getProperties());
	    }
	    else if(pVal.equalsIgnoreCase("link2")) {
	    	pw.println("<h1 style='color:red'>Date and Time ::"+new Date()+"</h1>");
	    }
	    else if(pVal.equalsIgnoreCase("btn1")) {
	    	pw.println("<h1 style='color:red'>Add::"+(val1+val2)+"</h1>");
	    }
	    else if(pVal.equalsIgnoreCase("btn2")) {
	    	pw.println("<h1 style='color:red'>Sub::"+(val1-val2)+"</h1>");
	    }
	    else {
	    	pw.println("<h1 style='color:red'>Mul::"+(val1*val2)+"</h1>");
	    }
	    //add home hyperlink
	    pw.println("<br><a href='form.html'>home</a>");
	    //close stream
	    	    pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
