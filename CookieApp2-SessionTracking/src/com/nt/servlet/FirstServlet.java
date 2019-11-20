package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null;
		Cookie ck1=null,ck2=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		//create Two cookies having form data
		ck1=new Cookie("name",name);
		ck2=new Cookie("fname",fname);
		//add cookies to the response
		res.addCookie(ck1); res.addCookie(ck2);
		//generate form2 dynamically form here
		pw.println("<h1 style='color:red;text-align:center'>Income Tax-Details </h1>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("Enter income of this year :: <input type='text' name='income'><br>");
		pw.println("Enter Tax Amount :: <input type='text' name='tax'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		//close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}//class
