package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
  private static final String INSERT_PERSONPROFILE="INSERT INTO PERSONALPROFILE VALUES(?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,ms=null;
		int age=0;
		String f2val1=null,f2val2=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1 /req1 data  (Session tracking)
		name=req.getParameter("hname");
		age=Integer.parseInt(req.getParameter("hage"));
		ms=req.getParameter("hms");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//write both form1/req1 and form2/req1 data as record to DB table
		try {
			//register JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement object
			ps=con.prepareStatement(INSERT_PERSONPROFILE);
			//set values to Query params
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(5,f2val2);
			//execute the SQL Query
			count=ps.executeUpdate();
			// process the result
			if(count==0)
				 pw.println("<h1 style='color:red;text-align:center'> Record insertion failed</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'> Record insertion succeded</h1>");
		}//try
		catch(SQLException se) {
			 pw.println("<h1 style='color:red;text-align:center'> Record insertion failed</h1>");
			 se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
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
		}
		//display  form1/req1 data and form2/req2 data
		pw.println("<h3> form1/req1 data::"+name+"..."+age+"..."+ms+"</h3>");
		pw.println("<br><h3> form2/req2 data::"+f2val1+"..."+f2val2+"</h3>");
		//add hyperlink
		pw.println("<br><br><a href='details.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
}
