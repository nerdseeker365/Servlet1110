//WordServlet.java
package com.nt.servlet;

import javax.servlet.*;  //servlet api
import javax.servlet.http.*; //servlet api
import java.io.*;  //IO API
 //Approach3
public class  WordServlet extends HttpServlet
{
	static{
		   System.out.println("WordServlet::static block");
	}
	public WordServlet(){
        System.out.println("WordServlet::0-param constructor");
	}
	public void init(ServletConfig cg){
        System.out.println("WordServlet::init(-) method");
	}
	protected  void service(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException{
		 System.out.println("WordServlet::service(-,-) method");
		PrintWriter pw=null;
           //get PrintWriter
		   pw=res.getWriter();
		   //set content type
		   res.setContentType("application/msword");
		   //display content
		   pw.println("<table border='1' bgcolor='cyan'>");
		   pw.println("<tr><th>Show name </th> <th> Host </th></tr>");
           pw.println("<tr><td>Big Boss-Telugu</td> <td>Natural Star-Nani </td></tr>");
    	   pw.println("<tr><td>Big Boss-Tamil</td> <td>Movie Navel-kamal hasan </td></tr>");
		   pw.println("<tr><td>Big Boss-Marathi</td> <td>The Foriegn Villan-Mahesh Manjerekar</td></tr>");
		   pw.println("<tr><td>Big Boss-Hindi</td> <td>Chichora Star-Salman khan</td></tr>");
		   pw.println("</table>");
		   //close stream
		   pw.close();
	}//service(-,-)
}//class
