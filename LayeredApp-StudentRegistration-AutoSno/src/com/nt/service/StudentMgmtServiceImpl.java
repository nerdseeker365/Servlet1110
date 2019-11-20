package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentMgmtServiceImpl implements StudentMgmtService {

	@Override
	public String register(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=null;
		int count=0;
		StudentBO bo=null;
		//write b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(dto.getM1()<35 || dto.getM2()<35 ||dto.getM3()<35)
			result="FAIL";
		else 
			result="PASS";
		//prepare BO class obj having persistable DAta
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//create and use DAO class obj
		dao=new StudentDAOImpl();
		count=dao.insert(bo);
		if(count==0)
			return "Registration failed---> result is::"+result;
		else 
			return "Registration succeded---> result is::"+result;
	}//method
}//class
