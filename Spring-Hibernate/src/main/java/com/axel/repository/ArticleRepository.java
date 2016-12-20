package com.axel.repository;

import java.util.Date;
import java.util.List;

import com.axel.entity.Article;

/**
 * The Interface ArticleRepository.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
public interface ArticleRepository {

	/**
	 * Insert article.
	 *
	 * @param article the article
	 * @return the article
	 */
	public Article insertArticle(Article article);

	/**
	 * Update article.
	 *
	 * @param article the article
	 * @return the article
	 */
	public Article updateArticle(Article article);

	/**
	 * Delete article.
	 *
	 * @param articleId the article id
	 * @return the string
	 */
	public String deleteArticle(Long articleId);

	/**
	 * Retrieve article.
	 *
	 * @param articleId the article id
	 * @return the article
	 */
	public Article retrieveArticle(String articleId);

	/**
	 * Retrieve articles of an author.
	 *
	 * @param author the author
	 * @return the list
	 */
	public List<Article> retrieveArticlesOfAnAuthor(String author);

	/**
	 * Retrieve articles of givenkeyword.
	 *
	 * @param keyword the keyword
	 * @return the list
	 */
	public List<Article> retrieveArticlesOfGivenkeyword(String keyword);
	
	/**
	 * Retrieve articles of given range.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the list
	 */
	public List<Article> retrieveArticlesOfGivenRange(Date fromDate, Date toDate);

}
