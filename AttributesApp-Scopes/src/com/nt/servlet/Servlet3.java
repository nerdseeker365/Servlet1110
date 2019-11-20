package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   RequestDispatcher rd=null;
	   HttpSession ses=null;
	   ServletContext sc=null;
	   //general settings
	   res.setContentType("text/html");
	   pw=res.getWriter();
	   //read and display req attribute vlues
	   pw.println("<br>(Servlet3) attr1 (req) attribute value :: "+req.getAttribute("attr1"));
	  //read and display ses attribute vlues
	   ses=req.getSession();
	   pw.println("<br>(Servlet3) attr2 (ses) attribute value :: "+ses.getAttribute("attr2"));
       //read and display sc attribute values
	   sc=getServletContext();
	   pw.println("<br>(Servlet3) attr3 (sc) attribute value :: "+sc.getAttribute("attr3"));


       //close stream
	   pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
