package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fileName=null;
		File file=null;
		ServletContext sc=null;
		InputStream is=null;
		OutputStream os=null;
		byte[] buffer=null;
		int bytesRead=0;
		PrintWriter pw=null;
		//get Access to Servletcontext obj
		sc=getServletContext();
		//read file name to download
		fileName=req.getParameter("file");
		//create java.io.File class object holding the Resource
		file=new File(sc.getRealPath("/")+fileName);
		System.out.println(file.getAbsolutePath());
		//get length of resource and make it as length of response obj
		res.setContentLengthLong(file.length());
		//get the MIME of the File and make it as response content type
		res.setContentType(sc.getMimeType(sc.getRealPath("/")+fileName));
		//create InputStream pointing to resource
		is=new FileInputStream(file);
		//create OutputStream pointing to response obj
		os=res.getOutputStream();
		pw=res.getWriter();
		//add "Content-Disposition" response header
		res.addHeader("Content-Disposition","attachment;fileName="+fileName);
		//write buffer based logic to copy resource content to response obj
		// so that file content to goes browser as response and becomes
		//downloadable file becoz "Content-Disposition" header.
		buffer=new byte[4096];
		while((bytesRead=is.read(buffer))!=-1) {
			os.write(buffer,0,bytesRead);
		}
		
		//close streams
		is.close();
		os.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}
