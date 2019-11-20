package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int val=0,cube=0;
		//general settings
		pw=res.getWriter();
		//set response content  type
		res.setContentType("text/html");
		// read form data
		val=Integer.parseInt(req.getParameter("no"));
		//calc cube value
		cube=val*val*val;
		//display cube value
		pw.println("<h1 style='color:red;text-align:center'>SecondServlet:: Cube value ::"+cube +"</h1>");
		//do  not close stream
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
