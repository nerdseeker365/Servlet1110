package com.nt.service;

public class JobSeekerServiceFactory {
	
	public static JobSeekerService  getInstance() {
		return new  JobSeekerServiceImpl();
	}

}
