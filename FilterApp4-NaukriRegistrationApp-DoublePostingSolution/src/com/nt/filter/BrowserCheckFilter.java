package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class BrowserCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String brName=null;
		HttpServletRequest hreq=null;
		RequestDispatcher rd=null;
		//typecasting
		hreq=(HttpServletRequest)req;
		//check the browser name
		 brName=hreq.getHeader("user-agent");
		 if(brName.indexOf("Chrome")==-1) {
		    rd=req.getRequestDispatcher("/browser_check.jsp");
		    rd.forward(req,res);
		    return;
		 }
		 else {
			 System.out.println("before BrowserCheckFilter.doFilter(-)");
			 chain.doFilter(req,res);
			 System.out.println("after BrowserCheckFilter.doFilter(-)");
		 }
		
		

	}

}
