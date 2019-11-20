//DBServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet
{ private static final String  GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";

	public  void doGet(HttpServletRequest req,
		                              HttpServletResponse res)throws ServletException,IOException{
		System.out.println("DBServlet::doGet(-,-)");
		PrintWriter pw=null;
		int no=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletContext sc=null;
		String driver=null,url=null,user=null,pwd=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		//Get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
         try{
        	 //includes the header content
        	 rd1=req.getRequestDispatcher("/headerurl");
        	 rd1.include(req,res);
        	  //get Access to ServletConfig obj
    		 sc=getServletContext();
        	 pw.println("<h1> hello </h1> <br>");
		 no=Integer.parseInt(req.getParameter("eno"));
		
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
			   
			   //includes the footer content
	        	 rd2=req.getRequestDispatcher("/footer.html");
	        	 rd2.include(req,res);
		 }//try
		 catch(Exception e){
			 
			 rd=sc.getRequestDispatcher("/errurl");
			// rd=sc.getNamedDispatcher("err");
			 //rd=sc.getRequestDispatcher("/error.jsp");
			 //rd=sc.getRequestDispatcher("/errorurl");
			 //rd=sc.getNamedDispatcher("errPage");
			 //rd=sc.getRequestDispatcher("/myError.html");
			 //rd=sc.getRequestDispatcher("/htmlurl");
			 //rd=sc.getNamedDispatcher("errPage1");
			 System.out.println("DBServlet.doGet()-->before rd.forward(-,-)");
			 pw.println("<b>DBServlet.doGet()-->before rd.forward(-,-)</b>");
			 rd.forward(req, res);
			 System.out.println("DBServlet.doGet()-->after rd.forward(-,-)");
			 pw.println("<b>DBServlet.doGet()-->after rd.forward(-,-)</b>");
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