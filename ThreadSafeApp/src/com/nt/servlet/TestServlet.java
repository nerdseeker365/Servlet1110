package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class TestServlet extends HttpServlet implements SingleThreadModel {
	
	public TestServlet() {
		System.out.println("TestServlet::0-param constructor");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
		//general settings
	   pw=res.getWriter();
	   pw.println("<h1> hello 12345566 </h1>");
	   try {
		   Thread.sleep(30000);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
		
		//close stream
	   pw.close();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	         doGet(req,res);	
	}
	

}
