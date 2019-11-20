//HtmlServlet.java
package com.nt.servlet;

//IO API
import java.io.IOException;
import java.io.PrintWriter;

//servlet api
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//servlet api
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Approach3
@WebServlet("/annoTest1")
public class  HtmlServlet extends HttpServlet
{
	static{
		   System.out.println("HtmlServlet::static block");
	}
	public HtmlServlet(){
        System.out.println("HtmlServlet::0-param constructor");
	}
	public void init(ServletConfig cg){
        System.out.println("HtmlServlet::init(-) method");
	}
	protected  void service(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException{
		 System.out.println("HtmlServlet::service(-,-) method");
		PrintWriter pw=null;
           //get PrintWriter
		   pw=res.getWriter();
		   //set content type
		   res.setContentType("text/html");
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
