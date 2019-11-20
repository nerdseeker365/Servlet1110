package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/*SQL> create table cookie_Tax(name varchar2(15),fname varchar2(15),income number(10),tax number(5));
*/

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String  INSERT_COOKIE_TAX="INSERT INTO COOKIE_TAX VALUES(?,?,?,?)";
	@Resource(name="DsJndi")
	private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cookies[]=null;
		String name=null,fname=null;
		int income=0,tax=0;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data  form cookies (Session TRacking)
		cookies=req.getCookies();
		if(cookies!=null) {
			name=cookies[0].getValue();
			fname=cookies[1].getValue();
		}
		//read form2/req2  data
		income=Integer.parseInt(req.getParameter("income"));
		tax=Integer.parseInt(req.getParameter("tax"));
		//write both form1/req1 and form2/req2 data to DB table as record
		try {
			//get Pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(INSERT_COOKIE_TAX);
			//set values to Query params
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setInt(3, income);
			ps.setInt(4, tax);
			//execute the Query
			count=ps.executeUpdate();
			//process the Results
			if(count==0)
				pw.println("Registration Failed");
			else
				pw.println("Registration Succeded");
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("Registration Failed");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("Registration Failed");
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
		//display form1/req1 and form2/req2 data on Dynamic webpage
		pw.println("<br><b>form1/req1 data :::"+name+"...."+fname+"</b>");
		pw.println("<br><b>form2/req2 data :::"+income+"...."+tax+"</b>");
		//add hyperlink
		pw.println("<br><a href='input.html'>home</a>");
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
