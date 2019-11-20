package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
   private HttpServletResponse res;
   private CharArrayWriter writer=null;
	public MyResponse(HttpServletResponse res) {
		super(res);
		this.res=res;
		writer=new CharArrayWriter();
		
	}
	
	public PrintWriter getWriter() {
		return new PrintWriter(writer);
	}
	
	@Override
		public String toString() {
		    return writer.toString();
		}

}
