package com.axel.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axel.entity.Article;

/**
 * The Interface ArticleDao extends spring-data-jpa interface to provide CRUD
 * operations and other required database calls.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
@Repository
public interface ArticleDao extends CrudRepository<Article, Long> {
	
	/**
	 * List articles of an author methods return articles of given author.
	 *
	 * @param author the author
	 * @return the list
	 */
	@Query("SELECT a FROM Article a WHERE LOWER(a.author) = LOWER(:author)")
    public List<Article> listArticlesOfAnAuthor(@Param("author") String author);
	
	/**
	 * List articles of given keyword methods return articles of given keyword.
	 *
	 * @param keywords the keywords
	 * @return the list
	 */
	@Query("SELECT a FROM Article a WHERE a.keywords LIKE CONCAT('%',:keywords,'%')")
	List<Article> listArticlesOfGivenKeyword(@Param("keywords") String keywords);
	
	/**
	 * List articles of given period.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the list
	 */
	@Query("SELECT a FROM Article a WHERE a.publishDate between :fromDate and :toDate")
	List<Article> listArticlesOfGivenPeriod(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	
}
