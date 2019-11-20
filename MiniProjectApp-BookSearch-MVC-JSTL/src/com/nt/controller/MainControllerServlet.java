package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.BookService;
import com.nt.service.BookServiceImpl;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private BookService service=null;
	
	@Override
	public void init() throws ServletException {
		service=new BookServiceImpl();
	}
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String category=null;
		String source=null;
		List<BookDTO> listDTO=null;
		String destPage=null;
		RequestDispatcher rd=null;
		//read form data
		category=req.getParameter("category");
		source=req.getParameter("source");
		try {
		//use SErvice  class
		listDTO=service.searchBooks(category);
		//keep results in  request scope
		req.setAttribute("listDTO",listDTO);
		//foward rquest result jsp
		if(source.equalsIgnoreCase("html"))
			destPage="/printHtml";
		else
			destPage="/printExcel";
		  rd=req.getRequestDispatcher(destPage); 
		   rd.forward(req,res);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	@Override
	public void destroy() {
	    service=null;
	}

}
