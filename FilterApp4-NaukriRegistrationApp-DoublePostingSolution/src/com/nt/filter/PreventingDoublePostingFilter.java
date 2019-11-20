package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter( "/controller")
public class PreventingDoublePostingFilter extends GenericFilter implements Filter {
       
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	   String formNo=null;
	   HttpSession ses=null;
	   int cToken=0,sToken=0;
	   RequestDispatcher rd=null;
	   formNo=req.getParameter("formNo");
	   ses=((HttpServletRequest)req).getSession();
	   if(formNo.equalsIgnoreCase("form2")) {
		   //generate Server Side token
		   ses.setAttribute("sToken",new Random().nextInt(10000));
		   chain.doFilter(req, res);
	   }
	   else if(formNo.equalsIgnoreCase("form3")) {
		   //read client and server side tokeen values
		   cToken=Integer.parseInt(req.getParameter("cToken"));
		   sToken=(int)ses.getAttribute("sToken");
		   //compare tokens
		   if(cToken==sToken) {
			   ses.setAttribute("sToken",new Random().nextInt(10000));
			   chain.doFilter(req, res);
		   }
		   else {
			   rd=req.getRequestDispatcher("/dbl_post.jsp");
			   rd.forward(req, res);
		   }
	   }
	   else {
		   chain.doFilter(req, res);
	   }
	}

	
}
