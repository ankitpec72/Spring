package com.axel.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="bookTable")
public class BookTable {
	
	private Book book;

	
	public BookTable(Book book) {
		super();
		this.book = book;
	}


	public Book getBook() {
		return book;
	}

}
