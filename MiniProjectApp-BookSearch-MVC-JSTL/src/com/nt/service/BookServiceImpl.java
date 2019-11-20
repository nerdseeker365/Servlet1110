package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.dao.BookDAO;
import com.nt.dao.BookDAOImpl;
import com.nt.dto.BookDTO;

public class BookServiceImpl implements BookService {
	private BookDAO dao;

	public BookServiceImpl() {
		dao = new BookDAOImpl();
	}

	@Override
	public List<BookDTO> searchBooks(String category) throws Exception {
       List<BookBO> listBO=null;
       final List<BookDTO> listDTO=new ArrayList();
		//use DAO
       listBO=dao.findBooks(category);
       //copy listBO to listDTO
       listBO.forEach(bo->{
    	   BookDTO dto=new BookDTO();
    	   dto.setBookId(bo.getBookId());
    	   dto.setBookName(bo.getBookName());
    	   dto.setAuthor(bo.getAuthor());
    	   dto.setPrice(bo.getPrice());
    	   dto.setStatus(bo.getStatus());
    	   dto.setCategory(bo.getCategory());
    	   //add DTO to listDTO
    	   listDTO.add(dto);
       });
		return listDTO;
	}//method
}//class
