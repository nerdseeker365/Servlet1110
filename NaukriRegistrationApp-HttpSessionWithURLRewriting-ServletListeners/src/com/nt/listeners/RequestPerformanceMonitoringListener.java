package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestPerformanceMonitoringListener implements ServletRequestListener {
   private long start,end;
   
   public RequestPerformanceMonitoringListener() {
	  System.out.println("RequestPerformanceMonitoringListener::0-param constructor");
    }
   
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		 start=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest req=null;
		ServletContext sc=null;
		end=System.currentTimeMillis();
		//get request obj
		req=(HttpServletRequest)sre.getServletRequest();
		//get ServletContext obj
		sc=req.getServletContext();
		sc.log(req.getRequestURL()+" has taken "+(end-start)+" ms to process the request");
	
	}
	
}
