package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.JobSeekerBO;

public class JobSeekerDAOImpl implements JobSeekerDAO {
	private static final String  INSERT_JOBSEEKER="INSERT INTO NAUKRI_JOBSEEKER VALUES(JSID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	
	private  Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource obj
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		//get Pooled Jdbc Con object
		con=ds.getConnection();
		return con;
	}

	@Override
	public int insert(JobSeekerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get Pooled Connection
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_JOBSEEKER);
		//set values to query params
		ps.setString(1,bo.getName());
		ps.setInt(2,bo.getAge());
		ps.setString(3,bo.getAddrs());
		ps.setString(4,bo.getSkill());
		ps.setInt(5,bo.getExperience());
		ps.setInt(6,bo.getExpSal());
		ps.setString(7,bo.getPreLoc());
		//execute the Query
		result=ps.executeUpdate();
		return result;
	}

}
