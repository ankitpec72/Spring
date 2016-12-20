package com.axel.view;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ArticleView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String articleHeader;

	private String articleDescription;

	private String articleText;

	private String articlePublishedDate;

	private String articleAuthor;

	private String articleKeywords;

	public ArticleView() {
	}

	public ArticleView(String articleHeader, String articleDescription, String articleText, String articlePublishedDate,
			String articleAuthor, String articleKeywords) {
		super();
		this.articleHeader = articleHeader;
		this.articleDescription = articleDescription;
		this.articleText = articleText;
		this.articlePublishedDate = articlePublishedDate;
		this.articleAuthor = articleAuthor;
		this.articleKeywords = articleKeywords;
	}

	public String getArticleHeader() {
		return articleHeader;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public String getArticleText() {
		return articleText;
	}

	public String getArticlePublishedDate() {
		return articlePublishedDate;
	}

	public String getArticleAuthor() {
		return articleAuthor;
	}

	public String getArticleKeywords() {
		return articleKeywords;
	}

}
