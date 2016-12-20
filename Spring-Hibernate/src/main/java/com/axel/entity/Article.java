package com.axel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The Class Article.
 */
@Entity
@Table(name = "Article")
public class Article implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The article key. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long articleKey;

	/** The header. */
	@NotNull
	@Column(name = "header")
	private String header;

	/** The description. */
	@NotNull
	@Column(name = "description")
	private String description;

	/** The text. */
	@NotNull
	@Column(name = "text")
	private String text;

	/** The publish date. */
	@NotNull
	@Column(name = "published_date")
	private Date publishDate;

	/** The author. */
	@NotNull
	@Column(name = "author")
	private String author;

	/** The keywords. */
	@NotNull
	@Column(name = "keywords")
	private String keywords;

	/**
	 * Instantiates a new article.
	 */
	public Article() {
	}

	/**
	 * Instantiates a new article.
	 *
	 * @param header the header
	 * @param description the description
	 * @param text the text
	 * @param publishDate the publish date
	 * @param author the author
	 * @param keywords the keywords
	 */
	public Article(long articleKey, String header, String description, String text, Date publishDate, String author,
			String keywords) {
		super();
		this.articleKey = articleKey;
		this.header = header;
		this.description = description;
		this.text = text;
		this.publishDate = publishDate;
		this.author = author;
		this.keywords = keywords;
	}	

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the publish date.
	 *
	 * @return the publish date
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the keywords.
	 *
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Gets the article key.
	 *
	 * @return the article key
	 */
	public long getArticleKey() {
		return articleKey;
	}

	/**
	 * Sets the article key.
	 *
	 * @param articleKey the new article key
	 */
	public void setArticleKey(long articleKey) {
		this.articleKey = articleKey;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
}
