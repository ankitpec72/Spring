package com.axel.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.axel.exception.ArticleException;

/**
 * The Class ArticleExceptionHandler is the handler for all ArticleException
 * occurs during journey.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
@Provider
public class ArticleExceptionHandler implements ExceptionMapper<ArticleException> {
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(ArticleException exception) 
	{
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}
}
