package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentMgmtService;
import com.nt.service.StudentMgmtServiceImpl;
import com.nt.vo.StudentVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
	 String sno=null,sname=null, m1=null,m2=null,m3=null;
	  StudentVO vo=null;
	  StudentDTO dto=null;
	  StudentMgmtService service=null;
	  String result=null;
		//general settings
	 pw=res.getWriter();
	 res.setContentType("text/html");
	 //read form data
	 sno=req.getParameter("sno");
	 sname=req.getParameter("sname");
	 m1=req.getParameter("m1");
	 m2=req.getParameter("m2");
	 m3=req.getParameter("m3");
	 //Store Form data into VO class object
	  vo=new StudentVO();
	  vo.setSno(sno); vo.setSname(sname);
	  vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
	  //Convert VO to DTO class obj
	  dto=new StudentDTO();
	  dto.setSno(Integer.parseInt(sno));
	  dto.setSname(sname);
	  dto.setM1(Integer.parseInt(m1));
	  dto.setM2(Integer.parseInt(m2));
	  dto.setM3(Integer.parseInt(m3));
	  //create and use Service class object
	  service=new StudentMgmtServiceImpl();
	  try {
		  result=service.register(dto);
		  pw.println("<h1 style='color:green'>"+result+"</h1>");
	  }
	  catch(Exception e) {
		  pw.println("<h1 style='color:red'>Internal Problem Try Again </h1>");
	  }
	  //add hyperlink
	  pw.println("<a href='form.html'><h3 style='color:red;text-align:center'>home</h3></a>");
	 //close stream 
	  pw.close();
	}//doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);	
	}//doPost(-,-)
}//class
