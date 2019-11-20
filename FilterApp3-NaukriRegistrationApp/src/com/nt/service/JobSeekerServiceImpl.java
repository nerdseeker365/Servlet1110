package com.nt.service;

import com.nt.bo.JobSeekerBO;
import com.nt.dao.JobSeekerDAO;
import com.nt.dao.JobSeekerDAOFactory;
import com.nt.dto.JobSeekerDTO;

public class JobSeekerServiceImpl implements JobSeekerService {
	 JobSeekerDAO dao;
	public JobSeekerServiceImpl() {
		//get DAO
		dao=JobSeekerDAOFactory.getInstance();
	}

	@Override
	public String register(JobSeekerDTO dto) throws Exception {
		JobSeekerBO bo=null;
		int count=0;
		//convert DTO to BO
		bo=new JobSeekerBO();
		bo.setName(dto.getName());
		bo.setAddrs(dto.getAddrs());
		bo.setAge(dto.getAge());
		bo.setExperience(dto.getExperience());
		bo.setSkill(dto.getSkill());
		bo.setPreLoc(dto.getPreLoc());
		bo.setExpSal(dto.getExpSal());
		//use DAO
		count=dao.insert(bo);
		if(count==0)
			return "Employee Registration failed";
		else
			return "Employee Registration succeded";
	}

}
