package com.axel.rest.services;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.axel.entity.Article;

/**
 * The Interface RESTArticleService exposed the REST Services for different resources.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
@Path("/articles")
public interface RESTArticleService {

	/**
	 * Creates the article.
	 *
	 * @param header the header
	 * @param description the description
	 * @param text the text
	 * @param publishedData the published data
	 * @param author the author
	 * @param keyWords the key words
	 * @return the string
	 */
	@POST
	@Path("/create")
	@Produces("application/text")
	public String createArticle(@FormParam("header") String header, @FormParam("description") String description,
			@FormParam("text") String text, @FormParam("author") String author,
			@FormParam("keywords") String keyWords);

	/**
	 * Update article.
	 *
	 * @param header the header
	 * @param description the description
	 * @param text the text
	 * @param publishedData the published data
	 * @param author the author
	 * @param keyWords the key words
	 * @param id the id
	 * @return the string
	 */
	@PUT
	@Path("/update")
	@Produces("application/text")
	public String updateArticle(@FormParam("header") String header, @FormParam("description") String description,
			@FormParam("text") String text, @FormParam("author") String author,
			@FormParam("keywords") String keyWords, @FormParam("articlekey") Long id);

	/**
	 * Delete article.
	 *
	 * @param key the key
	 * @return the string
	 */
	@DELETE
	@Path("/delete/{articlekey}")
	@Produces("application/text")
	public String deleteArticle(@PathParam("articlekey") Long key);

	/**
	 * Retrieve article.
	 *
	 * @param articleId the article id
	 * @return the response
	 */
	@GET
	@Produces("application/json")
	@Path("/retrievearticle/{articleid}")
	public Article retrieveArticle(@PathParam("articleid") String articleId);

	/**
	 * Retrieve articles of an author.
	 *
	 * @param author the author
	 * @return the response
	 */
	@GET
	// @Produces({"application/json", "text/plain"})
	@Path("/retrievearticlesofauthor/{author}")
	public Response retrieveArticlesOfAnAuthor(@PathParam("author") String author);

	/**
	 * Retrieve articles of givenkeyword.
	 *
	 * @param keyword the keyword
	 * @return the response
	 */
	@GET
	// @Produces({"application/json", "text/plain"})
	@Path("/retrievearticlesofkeyword/{keyword}")
	public Response retrieveArticlesOfGivenkeyword(@PathParam("keyword") String keyword);
	
	/**
	 * Retrieve articles of givenkeyword.
	 *
	 * @param keyword the keyword
	 * @return the response
	 */
	@GET
	@Path("/retrievearticlesofperiod/{from}/{to}")
	public Response retrieveArticlesOfGivenPeriod(@PathParam("from") String fromDate,@PathParam("to") String toDate);
	
}
