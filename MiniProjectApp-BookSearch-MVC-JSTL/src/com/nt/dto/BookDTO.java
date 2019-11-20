package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDTO implements Serializable {
	private int bookId;
	private String bookName;
	private String author;
	private String status;
	private float price;
	private String category;
	
}
