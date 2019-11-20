package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowBalanceServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    Random rad=null;
	    float balance=0.0f;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //generate Random Number
	    rad=new Random();
	    balance=rad.nextInt(10000000);
	    pw.println("<h1 style='color:red'>Balance :: "+balance+"</h1>");
	    //add home
	    pw.println("<br> <a href='index.html'>home </a>");
	    //close stream
	    pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
