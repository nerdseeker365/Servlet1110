package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cookies[]=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read cookies
		cookies=req.getCookies();
		//display cookies
		if(cookies!=null) {
			pw.println("<h1 style='color:red;text-align:center'> Cookies values are </h1>");
			pw.print("<table border='1'>");
			pw.println("<tr><th>Cookie name </th><th>Cookie value </th></tr>");
			  for(Cookie ck:cookies) {
				  pw.println("<tr>");
				   pw.println("<td>"+ck.getName()+"</td>");
				   pw.println("<td>"+ck.getValue()+"</td>");
				  pw.println("</tr>");
			  }
			pw.println("</table>");
		}
		//close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
