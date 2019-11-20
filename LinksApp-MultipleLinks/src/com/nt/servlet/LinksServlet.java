package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, 
			                          HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   Locale locales[]=null;
	   String  pValue=null;
		//general settings
	   pw=res.getWriter();
	   res.setContentType("text/html");
	   //get All Locales
	   locales=Locale.getAvailableLocales();
	   //read p1 request param value
	   pValue=req.getParameter("p1");
	   if(pValue.equalsIgnoreCase("link1")) {  //for Languages
		   pw.println("<br> <h2 style='color:red'> All Languages are </h2>");
		   for(Locale l:locales) {
			   pw.println("<br><b>"+l.getDisplayLanguage()+"</b>");
		   }
	   }
	   else if(pValue.equalsIgnoreCase("link2")) {
		   pw.println("<br> <h2 style='color:red'> All Countries are </h2>");
		   for(Locale l:locales) {
			   pw.println("<br><b>"+l.getDisplayCountry()+"</b>");
		   }
	   }
		   else {
			   pw.println("<br> <h2 style='color:red'>"+new Date()+" </h2>");
		   }
	   //add hyperlink
	   pw.println("<br><a href='links.html'>home</a>");
	   //close stream
	   pw.close();
	}///doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
