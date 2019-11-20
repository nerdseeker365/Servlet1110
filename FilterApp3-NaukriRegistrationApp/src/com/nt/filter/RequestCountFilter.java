package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class RequestCountFilter extends GenericFilter {
	int count;
	@Override
	public void init() throws ServletException {
	    count=0;
	}

	@Override
	public void doFilter(ServletRequest req,
			                              ServletResponse res,
			                              FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null;
		  //count requests 
		count++;
		//get Access to ServletContext obj
		//sc=getServletContext();
		 sc=req.getServletContext();
		 // keep request count in ServletContext obj
		 sc.setAttribute("reqCount",count);
		 //forward next filter or web comp
		 System.out.println("before RequestCountFilter.doFilter()");
		 chain.doFilter(req,res);
		 System.out.println("after RequestCountFilter.doFilter()");
	}//doFilter(-,-,-)

}
