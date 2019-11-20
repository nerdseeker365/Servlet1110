package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:process(-,-)");
		 PrintWriter pw=null;
		 String name=null,gender=null;
		 int age=0;
	   //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data (req param values)
		 name=req.getParameter("pname");
		 age=Integer.parseInt(req.getParameter("page"));
		 gender=req.getParameter("gen");
		 pw.println("<h1 style='color:green;text-align:center'>Shadi.com Results </h1>");
		 //write b.logic
		 if(gender.equalsIgnoreCase("M")){
			  if(age>=21)
				   pw.println("<h1 style='color:cyan;text-align:center'>Mr. "+name+" u  r eglible boy/man for marriage ,but still think once </h1>");
			  else
				  pw.println("<h1 style='color:maroon;text-align:center'>Mr. "+name+" u  r not eglible boy/man for marriage ,Feel happy </h1>");
		 }
		 else{
			 if(age>=18)
				   pw.println("<h1 style='color:cyan;text-align:center'>Miss. "+name+" u  r eglible girl/woman for marriage. keep u r terms and conditions </h1>");
			  else
				  pw.println("<h1 style='color:maroon;text-align:center'>Miss. "+name+" u  r not eglible girl/woman for marriage ,Feel Double happy and make others happy </h1>");
		 }
		 
		 //add hyperlink
		 pw.println("<br><a href='index.html'>home</a>");
		 
		 pw.println("<br>req obj class name::"+req.getClass());
		 pw.println("<br>res obj class name::"+res.getClass());
		 
		 //close stream
		 pw.close();
		
	}//doGet(-,-)
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet(-,-)");
	  process(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doPost(-,-)");
		 process(req,res);
	}
	
}//class
