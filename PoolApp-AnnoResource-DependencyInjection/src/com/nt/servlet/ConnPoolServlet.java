package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/poolurl")
public class ConnPoolServlet extends HttpServlet {
	@Resource(name="DsJndi")
	 private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String table=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int count=0;
		
		//read form data
		table=req.getParameter("table");
		try {
			//general settings
			pw=res.getWriter();
			res.setContentType("text/html");
		//get pooled jdbc con obj
			con=getPooledConnection();
		//create STaetment object	
			st=con.createStatement();
		//send and execute SQL Query
			rs=st.executeQuery("SELECT * FROM  "+table);
		//create ResultSetMetaData obj
			rsmd=rs.getMetaData();
		//get Column Count 
			count=rsmd.getColumnCount();
			//display col names
			pw.println("<table border='1' bgcolor='cyan'  align='center'>");
			pw.println("<tr style='color:blue'>");
			  for(int i=1;i<=count;++i) {
				  pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
			  }
			pw.println("</tr>");
			//display col values
			while(rs.next()) {
				pw.println("<tr>");
				for(int i=1;i<=count;++i) {
					pw.println("<td>"+rs.getString(i)+"</td>");
				}//for
				pw.println("</tr>");
			}//while
		 pw.println("</table>");	
			pw.println("<br><a href='input.html'>home </a>");
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			if(se.getErrorCode()==942)
				pw.println("<h1 style='color:red;'>wrong table name </h1>");
			else if(se.getErrorCode()==923)
				pw.println("<h1 style='color:red;'>Query Syntax problem </h1>");
			else 
				pw.println("<h1 style='color:red;'>Unknown DB problem</h1>");
			pw.println("<br><a href='input.html'>Try Again </a>");
		}
		catch(Exception e) {
			pw.println("<h1 style='color:red;'>Internal Unknown  problem</h1>");
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(pw!=null)
					pw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	
	//use defined method to Con obj from jdbc con pool
	private  Connection  getPooledConnection() throws SQLException,NamingException{
		//get Pooled jdbc con object
		return ds.getConnection();
	}//method
}//class
