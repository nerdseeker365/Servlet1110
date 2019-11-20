package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationMaintenceListener implements ServletContextListener {
	 private long start,end;
	 private ServletContext sc;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		start=System.currentTimeMillis();
		//get Access to Servletcontext obj
		sc=sce.getServletContext();
		//write log message
		sc.log(sc.getContextPath()+" web application is deployed/reloaded at "+new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		end=System.currentTimeMillis();
		//write log message
		sc.log(sc.getContextPath()+" web application is undeployed/reloaded at"+new Date());
		sc.log(sc.getContextPath()+" web application is in running mode for"+(end-start)+" ms");
	}

}
