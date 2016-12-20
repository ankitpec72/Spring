package com.axel.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.axel.entity.Article;
import com.axel.util.ApplicationUtil;
import com.axel.view.ArticleView;

/**
 * The Class ArticleServiceHelper contain utility methods to convert entity to view and vice-versa
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
public final class ArticleServiceHelper {

	/**
	 * Instantiates a new article service helper.
	 */
	private ArticleServiceHelper() {
	}

	/**
	 * Convert view to entity.
	 *
	 * @param articleId the article id
	 * @param header the header
	 * @param description the description
	 * @param text the text
	 * @param author the author
	 * @param keyWords the key words
	 * @return the article
	 */
	public static Article convertViewToEntity(Long articleId, String header, String description, String text,
			String author, String keyWords) {
		return new Article(articleId, header, description, text, new Date(), author, keyWords);
	}

	/**
	 * Convert entity to view.
	 *
	 * @param article the article
	 * @return the article view
	 */
	public static ArticleView convertEntityToView(Article article) {
		return new ArticleView(article.getHeader(), article.getDescription(), article.getText(),
				ApplicationUtil.convertDateToString(article.getPublishDate()), article.getAuthor(),
				article.getKeywords());
	}
	
	/**
	 * Convert entity to view.
	 *
	 * @param article the article
	 * @return the article view
	 */
	public static List<ArticleView> convertEntityToView1(Article article) {
		return getList(article);
	}
	
	private static List<ArticleView> getList(Article article)
	{
		List<ArticleView> view = new ArrayList<ArticleView>();
		
		view.add(new ArticleView(article.getHeader(), article.getDescription(), article.getText(),
				ApplicationUtil.convertDateToString(article.getPublishDate()), article.getAuthor(),
				article.getKeywords()));
		
		view.add(new ArticleView(article.getHeader(), article.getDescription(), article.getText(),
				ApplicationUtil.convertDateToString(article.getPublishDate()), article.getAuthor(),
				article.getKeywords()));
		
		view.add(new ArticleView(article.getHeader(), article.getDescription(), article.getText(),
				ApplicationUtil.convertDateToString(article.getPublishDate()), article.getAuthor(),
				article.getKeywords()));
		
		view.add(new ArticleView(article.getHeader(), article.getDescription(), article.getText(),
				ApplicationUtil.convertDateToString(article.getPublishDate()), article.getAuthor(),
				article.getKeywords()));
		
		return view;
	}

	/**
	 * Convert list to view.
	 *
	 * @param articles the articles
	 * @return the list
	 */
	public static List<ArticleView> convertListToView(List<Article> articles) {

		List<ArticleView> articleViewList = new ArrayList<ArticleView>();
		for (Article article : articles) {
			articleViewList.add(convertEntityToView(article));
		}
		return articleViewList;
	}

}
