package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
	static {
		System.out.println("MyWebAppInitializer.static method");
	}
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer.0-param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		System.out.println("MyWebAppInitializer.onStartup(-,-)");
		MarriageServlet servlet=null;
		ServletRegistration.Dynamic registration=null;
		//create Servlet class obj
		servlet=new MarriageServlet();
		//register servlet
	    registration=sc.addServlet("marriage",servlet);
	    registration.addMapping("/marriageurl");
	    registration.setLoadOnStartup(1);
	}

}
