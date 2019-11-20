package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class PerformenceTestFilter extends GenericFilter {
    private long start,end;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq=null;
		ServletContext sc=null;
		start=System.currentTimeMillis();
		chain.doFilter(req, res);
		end=System.currentTimeMillis();
		//type casting
		hreq=(HttpServletRequest)req;
		//get Access to ServletContext obj
		sc=hreq.getServletContext();
		sc.log(hreq.getRequestURI()+"  has taken "+(end-start)+" ms to process the requests");
	}

}
