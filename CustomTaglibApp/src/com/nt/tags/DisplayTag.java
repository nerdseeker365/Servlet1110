package com.nt.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	private String font;
	private int size=20;
	public void setFont(String font) {
		this.font = font;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("DisplayTag::doStartTag()");
		JspWriter out=null;
		ServletRequest req=null;
		String status=null;
		//get request object
		req=pageContext.getRequest();
		status=req.getParameter("print");

		try {
			// get  Out object
		out=pageContext.getOut();
		out.println("<table><tr><td><span style='font-size:"+size+"px;font-family:"+font+";'>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		if(status==null)
			return SKIP_BODY;
		else if(!status.equals("yes"))
			return SKIP_BODY;
		else
			return EVAL_BODY_INCLUDE;
		
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("DisplayTag::doEndTag()");
		JspWriter out=null;
		//get Out object
		out=pageContext.getOut();
		try {
			out.println("</span></td></tr></table>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//doEndTag()

}//class
