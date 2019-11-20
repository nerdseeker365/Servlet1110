package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/addurl")
public class InputsCheckFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	    System.out.println("InputsCheckFilter.init(-)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("InputsCheckFilter.doFilter(-,-,-)");
		PrintWriter pw=null;
		int val1=0,val2=0;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
		//check inputs
		if(val1<0 || val2<0) {
			pw.println("<h2 style='color:red'>Inputs must be positive numbers ........</h2>");
			pw.println("<br><a href='input.html'>home</a>");
			return;
		}
		else {
			System.out.println("InputsCheckFilter:: before chain.doFilter(-,-)");
			chain.doFilter(req,res);
			System.out.println("InputsCheckFilter:: after chain.doFilter(-,-)");
		}
		//close steam
		pw.close();

	}
	
	@Override
	public void destroy() {
	    System.out.println("InputsCheckFilter.destroy()");
	}

}
