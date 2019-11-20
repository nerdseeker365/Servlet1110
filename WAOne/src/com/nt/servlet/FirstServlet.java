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

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int val=0;
		int square=0;
		ServletContext sc=null,sc1=null;
		RequestDispatcher rd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		val=Integer.parseInt(req.getParameter("no"));
		//calc square value
		square=val*val;
		//display square value
		pw.println("<h1 style='color:red;text-align:center'>(FirstServlet)Square Value ::"+square+"</h1>");
		//get current web application's ServletContext obj
		sc=getServletContext();
		//get ForiegnContext 
		sc1=sc.getContext("/WATwo");
		//get RquestDispatcher obj pointing to SEcondServlet
        rd=sc1.getRequestDispatcher("/secondurl");
        //include the output of SecondServlet comp to response obj
        rd.include(req,res);
        //add hyperlink
        pw.println("<br><a href='form.html'>home</a>");
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           doGet(req,res);
	}

}
