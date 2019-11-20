package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     PrintWriter pw=null;
	     MultipartFormDataRequest nreq=null;
	     UploadBean upb=null;
	     Hashtable<String,UploadFile> uploadedFiles=null;
	     Enumeration<UploadFile> e=null;
	     UploadFile file=null;
		//general settings
	     pw=res.getWriter();
	     res.setContentType("text/html");
	     try {
	     //create Special Request object
	     nreq=new MultipartFormDataRequest(req);
	     //perform file upload settings
	     upb=new UploadBean();
	     upb.setFolderstore("d:/store");
	     upb.setOverwrite(false);
	     upb.setFilesizelimit(10240);
	     //perform file uploading
	     upb.store(nreq);
	     pw.println("<h1 style='color:red;text-align:center'>Files are Uploaded </h1>");
	     }//try
	     catch(Exception ex) {
	    	 pw.println("<h1 style='color:red;text-align:center'>Problem in File Uploading</h1>");
	    	 return ;
	     }
	     
	     pw.println("<b> the names of upload files are</b><br>");
	     uploadedFiles=nreq.getFiles();
	     e=uploadedFiles.elements();
	     while(e.hasMoreElements()) {
	    	 file=e.nextElement();
	    	 pw.println(file.getFileName()+" "+file.getFileSize()+" "+file.getContentType()+"<br>");
	     }
	     //add hyperlink
	     pw.println("<a href='upload.html'>home</a>");
	     //close strea
	     pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	       doGet(req,res);
	}

}
