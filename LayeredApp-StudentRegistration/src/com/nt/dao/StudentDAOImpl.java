package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_LAYERED_STUDENT="INSERT INTO LAYERED_STUDENT VALUES(?,?,?,?,?)";
	
	private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource obj from Jndi registery
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled jdbc con object
		con=ds.getConnection();
		return con;
	}//method

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get Pooled connection
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_LAYERED_STUDENT);
		//set values to query params
		ps.setInt(1,bo.getSno());
		ps.setString(2,bo.getSname());
		ps.setInt(3,bo.getTotal());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		//execute the SQL query
		result=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return result;
	}

}
