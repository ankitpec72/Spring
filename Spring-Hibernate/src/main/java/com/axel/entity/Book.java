package com.axel.entity;

import java.util.List;

import com.axel.view.ArticleView;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="book")
public class Book {
	
	private String bookId;
	
	private List<ArticleView> articleView;
	
	public Book(String bookId, List<ArticleView> articleView) {
		super();
		this.bookId = bookId;
		this.articleView = articleView;
	}

	public String getBookId() {
		return bookId;
	}

	public List<ArticleView> getArticleView() {
		return articleView;
	}
	
	
	

}
