package com.axel.rest.services;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axel.entity.Article;
import com.axel.entity.Book;
import com.axel.entity.BookTable;
import com.axel.exception.ArticleException;
import com.axel.helper.ArticleServiceHelper;
import com.axel.repository.ArticleRepository;
import com.axel.util.ApplicationUtil;

/**
 * The Class RESTArticleServiceImpl in the implementor of REST services.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
@Service
public class RESTArticleServiceImpl implements RESTArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * The createArticle method accepts the data as form params and calls the
	 * DAO to insert new article in DB
	 * 
	 * @param header
	 *            the header
	 * @param description
	 *            the description
	 * @param text
	 *            the text
	 * @param publishedDate
	 *            the published date
	 * @param author
	 *            the author
	 * @param keyWords
	 *            the keywords
	 * 
	 * @return String
	 * 
	 */

	@Override
	public String createArticle(String header, String description, String text, String author, String keyWords) {

		Article articleCreated = articleRepository.insertArticle(
				ArticleServiceHelper.convertViewToEntity(0L, header, description, text, author, keyWords));
		return "Article succesfully created! (id = " + articleCreated.getArticleKey() + ")";
	}

	/**
	 * The updateArticle method accepts the data as form params and calls the
	 * DAO to update article in DB
	 * 
	 * @param header
	 *            the header
	 * @param description
	 *            the description
	 * @param text
	 *            the text
	 * @param publishedDate
	 *            the published date
	 * @param author
	 *            the author
	 * @param keyWords
	 *            the keywords
	 * @param id
	 *            the article id
	 * 
	 * @return String message
	 */
	@Override
	public String updateArticle(String header, String description, String text, String author, String keyWords,
			Long id) {

		articleRepository.updateArticle(
				ArticleServiceHelper.convertViewToEntity(id, header, description, text, author, keyWords));
		return "Article Updated Successfully";
	}

	/**
	 * The deleteArticle method deletes the article by calling required DAO
	 * service
	 * 
	 * @param articleId
	 *            the articleId
	 * 
	 * @return String message
	 */
	@Override
	public String deleteArticle(Long articleId) {

		if (null == articleId) {
			throw new ArticleException("Please pass article id to delete the record");
		}
		articleRepository.deleteArticle(articleId);
		return "Article Deleted Successfully";
	}

	/**
	 * The retrieveArticle method retrieve the article by calling required DAO
	 * service
	 * 
	 * @param articleId
	 *            the articleId
	 * 
	 * @return Response
	 */
	@Override
	public Article retrieveArticle(String articleId) {

		if (ApplicationUtil.isStringNullOrEmpty(articleId)) {
			throw new ArticleException("Article Id cannot be null/empty");
		}

		Article existingArticle = articleRepository.retrieveArticle(articleId);
//		if (existingArticle == null) {
//			String errorString = "No Articles found for given Article Id: " + articleId;
//			return Response.status(Response.Status.NOT_FOUND).entity(errorString).build();
//		}
//		return Response.status(Response.Status.OK).entity(new BookTable(new Book(articleId,ArticleServiceHelper.convertEntityToView1(existingArticle))))
//				.type(MediaType.APPLICATION_JSON_TYPE).build();
		
		return existingArticle;
	}

	/**
	 * The retrieveArticlesOfAnAuthor method retrieve the article of an Author
	 * by calling required DAO service
	 * 
	 * @param author
	 *            the author
	 * 
	 * @return Response the response
	 */
	@Override
	public Response retrieveArticlesOfAnAuthor(String author) {

		if (ApplicationUtil.isStringNullOrEmpty(author)) {
			throw new ArticleException("Author name cannot be blank");
		}

		List<Article> articles = articleRepository.retrieveArticlesOfAnAuthor(author);
		if (ApplicationUtil.isListNullOrEmpty(articles)) {
			String errorString = "No Articles found for given Author: " + author;
			return Response.status(Response.Status.NOT_FOUND).entity(errorString).build();
		}
		return Response.status(Response.Status.OK).entity(ArticleServiceHelper.convertListToView(articles))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	/**
	 * The retrieveArticlesOfGivenkeyword method retrieve the article of given
	 * keyword by calling required DAO service
	 * 
	 * @param keyword
	 *            the keyword
	 * 
	 * @return Response the response
	 */
	@Override
	public Response retrieveArticlesOfGivenkeyword(String keyword) {

		if (ApplicationUtil.isStringNullOrEmpty(keyword)) {
			throw new ArticleException("Keyword Can't be null for search");
		}

		List<Article> articles = articleRepository.retrieveArticlesOfGivenkeyword(keyword);

		if (ApplicationUtil.isListNullOrEmpty(articles)) {
			String errorString = "No Articles found for given keyword: " + keyword;
			return Response.status(Response.Status.NOT_FOUND).entity(errorString).build();
		}
		return Response.status(Response.Status.OK).entity(ArticleServiceHelper.convertListToView(articles))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
	
	/**
	 * The retrieveArticlesOfGivenPeriod method retrieve the article of given
	 * time period by calling required DAO service
	 * 
	 * @param fromDate
	 *            the todate
	 * 
	 * @return list the List
	 */

	@Override
	public Response retrieveArticlesOfGivenPeriod(String fromDate, String toDate) {

		List<Article> articles = articleRepository.retrieveArticlesOfGivenRange(ApplicationUtil.getParsedDate(fromDate), ApplicationUtil.getParsedDate(toDate));

		if (ApplicationUtil.isListNullOrEmpty(articles)) {
			String errorString = "No Articles found for given Time Period from : " + fromDate + "TO :" + toDate;
			return Response.status(Response.Status.NOT_FOUND).entity(errorString).build();
		}
		return Response.status(Response.Status.OK).entity(ArticleServiceHelper.convertListToView(articles))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
