package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;
import com.nt.wrapper.MyResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/loginurl")
public class LoginFilter extends GenericFilter  {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		MyRequest mreq=null;
		MyResponse mres=null;
		String msg=null;
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//create CustomRequest object,CustomResponse obj
		mreq=new MyRequest(((HttpServletRequest)req));
		mres=new MyResponse((HttpServletResponse)res);
		chain.doFilter(mreq, mres);
		//wrtie response filter obj to modify res obj data
		msg=mres.toString();
		msg=msg+"<br><br><hr> @Naresht It";
		//write modified output to response obj
		pw.println(msg);
		//close stream
		pw.close();
	}//doFilter(-,-)

}
