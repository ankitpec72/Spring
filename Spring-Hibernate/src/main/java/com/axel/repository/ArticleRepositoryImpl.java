package com.axel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axel.dao.ArticleDao;
import com.axel.entity.Article;

/**
 * The Class ArticleRepositoryImpl.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
@Service
public class ArticleRepositoryImpl implements ArticleRepository {

	/** The article dao. */
	@Autowired
	private ArticleDao articleDao;

	/**
	 * The insertArticle method calls the DAO to insert article in DB.
	 *
	 * @param article the article
	 * @return String message
	 */
	@Override
	public Article insertArticle(Article article) {

		return articleDao.save(article);
	}

	/**
	 * The updateArticle method accepts the data as form params and calls the
	 * DAO to update article in DB.
	 *
	 * @param article the article
	 * @return String message
	 */
	@Override
	public Article updateArticle(Article article) {

		return articleDao.save(article);
	}

	/**
	 * The deleteArticle method deletes the article by calling required DAO
	 * service.
	 *
	 * @param articleId            the articleId
	 * @return String message
	 */
	@Override
	public String deleteArticle(Long articleId) {

		articleDao.delete(articleId);
		return "Article Deleted Successfully";
	}

	/**
	 * The retrieveArticle method retrieve the article by calling required DAO
	 * service.
	 *
	 * @param articleId    the articleId
	 * @return article the article
	 */
	@Override
	public Article retrieveArticle(String articleId) {

		return articleDao.findOne(Long.parseLong(articleId));
	}

	/**
	 * The retrieveArticlesOfAnAuthor method retrieve the article of an Author
	 * by calling required DAO service.
	 *
	 * @param author            the author
	 * @return list the list
	 */
	@Override
	public List<Article> retrieveArticlesOfAnAuthor(String author) {

		return articleDao.listArticlesOfAnAuthor(author);
	}

	/**
	 * The retrieveArticlesOfGivenkeyword method retrieve the article of given
	 * keyword by calling required DAO service.
	 *
	 * @param keyword the keyword
	 * @return list the list
	 */
	@Override
	public List<Article> retrieveArticlesOfGivenkeyword(String keyword) {

		return articleDao.listArticlesOfGivenKeyword(keyword);
	}

	/**
	 * The retrieveArticlesOfGivenRange method retrieve the article of given
	 * time period by calling required DAO service.
	 *
	 * @param fromDate the date
	 * @return toDate the date
	 */
	@Override
	public List<Article> retrieveArticlesOfGivenRange(Date fromDate, Date toDate) {

		return articleDao.listArticlesOfGivenPeriod(fromDate, toDate);
	}
}
