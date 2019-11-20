package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionMonitoringListener implements HttpSessionListener {
    private long start,end;
    private ServletContext sc;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		start=System.currentTimeMillis();
		//get Access toServletContext obj
	   sc=se.getSession().getServletContext();
	   //write log message
	   sc.log("Sesion started at::"+new Date());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		end=System.currentTimeMillis();
		//write log message
		sc.log("Session ended at ::"+new Date());
		sc.log(se.getSession().getId()+" session duration "+(end-start)+" ms");
	}
	
}
