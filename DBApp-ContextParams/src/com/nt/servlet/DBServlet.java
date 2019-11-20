//DBServlet.java
package com.nt.servlet;

import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DBServlet extends HttpServlet
{ private static final String  GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";

	public  void doGet(HttpServletRequest req,
		                              HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		int no=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletContext sc=null;
		String driver=null,url=null,user=null,pwd=null;
		//Get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		
		
         try{
		 no=Integer.parseInt(req.getParameter("eno"));
		  //get Access to ServletConfig obj
		 sc=getServletContext();
		 //read init params
		 driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("url");
			user=sc.getInitParameter("dbuser");
			pwd=sc.getInitParameter("dbpwd");
		 //register driver s/w
		    Class.forName(driver);
         //establish the connection
		    con=DriverManager.getConnection(url,user,pwd);
			//create PreparedStatement object
			ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
			//set input values to query params
			ps.setInt(1,no);
			//execute Query
               rs=ps.executeQuery();
			   //process the ResultSet obj
			   if(rs.next()){
				   pw.println("<h1 style='color:red'>Employee Details are </h1>");
				   pw.println("<br><b> Employee number:: "+rs.getInt(1)+"</b>");
				   pw.println("<br><b> Employee name:: "+rs.getString(2)+"</b>");
				   pw.println("<br><b> Employee Desg:: "+rs.getString(3)+"</b>");
				   pw.println("<br><b> Employee salary:: "+rs.getInt(4)+"</b>");
			   }//if
			   else{
				    pw.println("<h1 style='color:red'>Employee Not Found </h1>");
			   }
			   //add hyperlink
			   pw.println("<br> <a href='input.html'>home</a>");
			   
			   
			   pw.println("<br> ServletConfig obj class name::"+sc.getClass());
			  
		 }//try
		 /*catch(ClassNotFoundException cnf){
			  cnf.printStackTrace();
		 }*/
		 catch(SQLException se){
            se.printStackTrace();
		 }
		 catch(Exception e){
                  e.printStackTrace();
		 }
		 finally{
			 try{
				 if(rs!=null)
					 rs.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
			  try{
				 if(ps!=null)
					 ps.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
			  try{
				 if(con!=null)
					 con.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
			  try{
				 if(pw!=null)
					 pw.close();
			 }
			 catch(Exception se){
				 se.printStackTrace();
			 }
		 }//finally
	}//doGet(-,-)

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
            doGet(req,res);
	}//doPost(-,-)
}//class