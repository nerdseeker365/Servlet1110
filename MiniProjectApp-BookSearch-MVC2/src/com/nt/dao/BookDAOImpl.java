package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookBO;

public class BookDAOImpl implements BookDAO {
	private static final String  GET_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,AUTHORNAME,PRICE,STATUS,CATEGORY FROM BOOK_DETAILS WHERE CATEGORY=?";

	private Connection getPooledConnection() throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//get DataSource obj from jndi registry
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled Jdbc con obj
		con=ds.getConnection();
		return con;
	}
	
	@Override
	public List<BookBO> findBooks(String category) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBO> listBO=null;
		BookBO bo=null;
		try {
		//get pooled jdbc con obj
		con=getPooledConnection();
		//create PreparedSTaement obj
		ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);
		//set query param value
		ps.setString(1, category);
		//execute the Query
		rs=ps.executeQuery();
		//process the ResultSet and copy it to ArrayList obj
		listBO=new ArrayList();
		while(rs.next()) {
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPrice(rs.getFloat(4));
			bo.setStatus(rs.getString(5));
			bo.setCategory(rs.getString(6));
			listBO.add(bo);
		}
		}//try
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				throw se;
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				throw se;
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				throw se;
			}
		}
		
		return listBO;
	}//findBooks(-)
}//class
