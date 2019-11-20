//LcTestServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LcTestServlet  extends  HttpServlet
{   
	static{
	   System.out.println("LcTestServlet:static block");
        }
     public  LcTestServlet(){
           System.out.println("LcTestServlet:0-param constructor");
	 }
	 public void init(ServletConfig cg)throws ServletException{
          super.init(cg);		
           System.out.println("LcTestServlet:init(ServletConfig)");
		   System.out.println("dbuser init param value:::"+cg.getInitParameter("dbuser"));
		   System.out.println("dbpwd init param value:::"+cg.getInitParameter("dbpwd"));
		   System.out.println("ServletConfig object class name::"+cg.getClass());

	 }

	  /*public void init(){
          System.out.println("LcTestServlet:init()");
		  ServletConfig cg=getServletConfig();
		  System.out.println("dbuser  init param value::"+cg.getInitParameter("dbuser"));
	 }*/

	  public  void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
            System.out.println("LcTestServlet:service(-,-)");
			PrintWriter pw=null;
			//general settings
			pw=res.getWriter();
			res.setContentType("text/html");
			//write output content to response object
			pw.println("<h1 style='color:red'>System Date and Time ::"+new java.util.Date() +"</h1>");
           try{
			   ServletConfig cg=getServletConfig();
		  System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
		   }
		   catch(Exception e){
			   e.printStackTrace();
		   }


			//close stream
			pw.close();
	  }//service(-,-)

	  public void destroy(){
             System.out.println("LcTestServlet:destroy()");
	  }//destroy()

}//class