package com.nt.dao;

public class JobSeekerDAOFactory {
	public static  JobSeekerDAO getInstance() {
		  return new JobSeekerDAOImpl();
	}

}
