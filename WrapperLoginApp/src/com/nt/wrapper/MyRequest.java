package com.nt.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
   private HttpServletRequest req;
	public MyRequest(HttpServletRequest req) {
		super(req);
		this.req=req;
	}
	
	public String  getParameter(String name) {
		String pval=req.getParameter(name);
		if(name.equalsIgnoreCase("t1")) {
			if(!pval.endsWith("@gmail.com"))
				pval=pval+"@gmail.com";
		}
		return pval;
	}

}
