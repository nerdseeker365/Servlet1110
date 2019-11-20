package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int age=0;
		 String name=null,addrs=null,gender=null,ms=null,qlfy=null,hobies[]=null,courses[]=null;
		 //get PrintWriter 
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read form data
		 name=req.getParameter("pname");
		 age=Integer.parseInt(req.getParameter("page"));
		 addrs=req.getParameter("taddrs");
		 ms=req.getParameter("ms");
		 if(ms==null)
			 ms="single";
		 
		 gender=req.getParameter("gen");
		 courses=req.getParameterValues("courses");
		 if(courses==null){
			 courses=new String[1];
			 courses[0]="no course is selected";
		 }
			 
		 hobies=req.getParameterValues("hb");
		 qlfy=req.getParameter("qlfy");
		 if(qlfy.equals("") || qlfy.length()==0)
			 qlfy="no qualification is selected";
		 //process the results
		 if(gender.equalsIgnoreCase("M")){
			 if(age<=5)
				   pw.println("<h1> Master."+name +" u  r  a baby Boy");
			 else if(age<=12)
				 pw.println("<h1> Master."+name +" u  r  a small Boy");
			 else if(age<=19)
				 pw.println("<h1> Master/Mr."+name +" u  r  a teenage Boy");
			 else if(age<=35)
				 pw.println("<h1> Mr."+name +" u  r  a young man");
			 else if(age<=50)
				 pw.println("<h1> Mr."+name +" u  r  a middle-aged man");
			 else
				 pw.println("<h1> Mr."+name +" u  r  a Budda");
		 }//if
		 else {
			 if(age<=5)
				   pw.println("<h1> Master."+name +" u  r  a baby girl");
			 else if(age<=12)
				 pw.println("<h1> Master."+name +" u  r  a little girl");
			 else if(age<=19){
				   if(ms.equalsIgnoreCase("married"))
				          pw.println("<h1> Mrs."+name +" u  r  a married girl");
				   else
					   pw.println("<h1> Miss."+name +" u  r  a young girl");
			 }
			 else if(age<=35){
				  if(ms.equalsIgnoreCase("married"))
			          pw.println("<h1> Mrs."+name +" u  r  a married young woman");
			   else
				   pw.println("<h1> Miss."+name +" u  r  a young woman");
			 }
			 else if(age<=50){
				  if(ms.equalsIgnoreCase("married"))
			          pw.println("<h1> Mrs."+name +" u  r  a married middle-aged woman");
			   else
				   pw.println("<h1> Miss."+name +" u  r  a middle-aged woman");
			 }
			 else{
				  if(ms.equalsIgnoreCase("married"))
			          pw.println("<h1> Mrs."+name +" u  r  a married Buddi");
			   else
				   pw.println("<h1> Miss."+name +" u  r  a single buddi");
			 }//else
		 }//else
		 //display Form data...
		 pw.println("<h1 style='color:red;text-align:center'> Recieved Form data </h1>");
		 pw.println("<br> <b> name:: </b>"+name);
		 pw.println("<br> <b> age:: </b>"+age);
		 pw.println("<br> <b> address:: </b>"+addrs);
		 pw.println("<br> <b>Marital status::</b>"+ms);
		 pw.println("<br> <b> gender:: </b>"+gender);
		 pw.println("<br> <b> Qualification:: </b>"+qlfy);
		 pw.println("<br> <b> courses:: </b>"+Arrays.toString(courses));
		 pw.println("<br> <b> hobies:: </b>"+Arrays.toString(hobies));
		 //add hyperlink
		 pw.println("<br> <a href='form.html'>home </a>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}
