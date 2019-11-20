package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.JobSeekerDTO;
import com.nt.service.JobSeekerService;
import com.nt.service.JobSeekerServiceFactory;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	  private JobSeekerService service;
	@Override
	public void init() throws ServletException {
	    service=JobSeekerServiceFactory.getInstance();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    String formNo=null;
	    String name=null, addrs=null,skill=null,loc=null;
	    int age=0,exp=0,expSal=0;
	    HttpSession ses=null;
	    JobSeekerDTO dto=null;
	    String registrationStatus=null;
	    RequestDispatcher rd=null;
	    		
		//general settings
	    res.setContentType("text/html");
	    pw=res.getWriter();
	    //read formNumber from hidden Box
	    formNo=req.getParameter("formNo");
	   if(formNo.equalsIgnoreCase("form1")) {
		   //read form1/req1 data
		   name=req.getParameter("name");
		   addrs=req.getParameter("addrs");
		   age=Integer.parseInt(req.getParameter("age"));
		   //create Session obj 
		   ses=req.getSession(true);
		   //keep form1/req1 data in HttpSession obj as session attribute values
		   ses.setAttribute("name",name);
		   ses.setAttribute("addrs",addrs);
		   ses.setAttribute("age",age);
		   System.out.println(req.getRequestURL());
		   //generate form2 dymically here
		   pw.println("<h1 style='color:red;text-align:center'>Naukri.com Regsration Form No:2 </h1>");
		   pw.println("<form action="+res.encodeURL("controller")+" method='POST'>");
		     pw.println("Select Skill set: <select name='skill' >");
             pw.println("<option value='java'>JAVA </option>");
             pw.println("<option value='.net'>.NET </option>");
             pw.println("<option value='php'>PHP</option>");
             pw.println("<option value='oracle'>Oracle </option>");
             pw.println("</select><br>");
             pw.println("Experience: <input type='text'  name='exp' > <br>");
             pw.println("<input type='hidden'  name='formNo' value='form2'> <br>");
             pw.println("<input type='submit' value='continue'>");
		   pw.println("</form>");
		   pw.println("<br><br> SessionId ::"+ses.getId());
	   }
	   else if(formNo.equalsIgnoreCase("form2")) {
		   System.out.println(req.getRequestURL());
		    //read form2/req2 data
		   skill=req.getParameter("skill");
		   exp=Integer.parseInt(req.getParameter("exp"));
		   //get Access to Session obj
		   ses=req.getSession(false);
		 /*  ses.setMaxInactiveInterval(60);*/
		   //keep form2/req2 data in Session obj as Session attribute values
		   ses.setAttribute("skill", skill);
		   ses.setAttribute("exp",exp);
		   //generate form3 dymically here
		   pw.println("<h1 style='color:red;text-align:center'>Naukri.com Regsration Form No:3 </h1>");
		   pw.println("<form action="+res.encodeURL("controller")+" method='POST'>");
		     pw.println("Preffered Location: <input type='text' name='loc'><br>");
             pw.println("Expected Salary: <input type='text'  name='expSal' > <br>");
             pw.println("<input type='hidden'  name='formNo' value='form3'> <br>");
             pw.println("<input type='submit' value='submit'>");
		   pw.println("</form>");
		   pw.println("<br><br> SessionId ::"+ses.getId());
	   }
	   else if(formNo.equalsIgnoreCase("form3")) {
		   System.out.println(req.getRequestURL());
		   //read form3/req3 data
		   loc=req.getParameter("loc");
		   expSal=Integer.parseInt(req.getParameter("expSal"));
		   //get Accesss to Session
		   ses=req.getSession(false);
		   //read form1/req1 and form2/req2 data from Session
		   name=(String)ses.getAttribute("name");
		   age=(Integer)ses.getAttribute("age");
		   addrs=(String)ses.getAttribute("addrs");
		   skill=(String)ses.getAttribute("skill");
		   exp=(Integer)ses.getAttribute("exp");
		   //prepare DTO class object
		   dto=new JobSeekerDTO();
		   dto.setName(name);
		   dto.setAge(age);
		   dto.setAddrs(addrs);
		   dto.setSkill(skill);
		   dto.setExperience(exp);
		   dto.setPreLoc(loc);
		   dto.setExpSal(expSal);
		   try {
		   //use Service
		   registrationStatus=service.register(dto);
		     pw.println("<h1 style='color:red;text-align:center'>"+registrationStatus+"</h1>");
		     pw.println("<br><br> SessionId ::"+ses.getId());
		     ses.invalidate();
		   }
		   catch(Exception e) {
			   //forward to error page
			   rd=req.getRequestDispatcher("/error.jsp");
			   rd.forward(req,res);
			   //invalidate the session
			   ses.invalidate();
		   }
	   }//else
	   //add hyperlink
	   pw.println("<br> <a href='personal.jsp'>home</a>");
	   pw.println("<br> req count is ::"+req.getServletContext().getAttribute("reqCount")+"<br>");
	   //clos stream 
	   pw.close();
		   
	   }//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
