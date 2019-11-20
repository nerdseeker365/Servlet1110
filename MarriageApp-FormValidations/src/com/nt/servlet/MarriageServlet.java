package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:doGet(-,-)");
		 final PrintWriter pw=res.getWriter();
		 String name=null,gender=null,tage=null;
		 int age=0;
		 ArrayList<String> errList=null;
		 String vstatus=null;
	   //general settings
	 res.setContentType("text/html");
		 //read form data (req param values)
		 name=req.getParameter("pname");
		 tage=req.getParameter("page");		 
		 gender=req.getParameter("gen");
     //read vflag value to know that status  of client side valiations
		 vstatus=req.getParameter("vflag");
		 if(vstatus.equalsIgnoreCase("no")){
		  //Server formValidation logic
		 errList=new ArrayList();
		 System.out.println("Server side form validation errors");
		  if(name==null || name.length()==0 || name.equals("")){
			  errList.add("person name is required");
		  }
		  if(tage==null || tage.length()==0 || tage.equals("")){
			 errList.add("person age is required");
     	  }
		  else{
			    try{
			    	age=Integer.parseInt(tage);
			    	  if(age<1  || age>125){
			    		  errList.add("person age must be in the range 1 throguh 125");
			    	  }
			    }
			    catch(NumberFormatException nfe){
			    	errList.add("person age must be numeric value");
			    }
		  }//if
		  if(!errList.isEmpty()){
			//  for(String err:errList){
				//  pw.println("<li style='color:red'><b>"+err+"</b></li>");
			 // }
			  errList.forEach(err->{
				  pw.println("<li style='color:red'><b>"+err+"</b></li>");
			  });
			  return;
		  }
		 }//if
		 else{
			 age=Integer.parseInt(tage);
		 }
		 
		 //write b.logic             (m)
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
		 pw.println("<br><a href='input.html'>home</a>");
		 
		 //close stream
		 pw.close();
		
	}//doGet(-,-)
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doPost(-,-)");
		doGet(req,res);
	}
	
	
	
}//class
