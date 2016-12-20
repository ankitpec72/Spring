package com.axel.exception;

/**
 * The Class ArticleException is Runtime Exception.
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
public class ArticleException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new article exception.
	 */
	public ArticleException() {
		super();
	}

	/**
	 * Instantiates a new article exception.
	 *
	 * @param msg the msg
	 */
	public ArticleException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new article exception.
	 *
	 * @param msg the msg
	 * @param e the e
	 */
	public ArticleException(String msg, Exception e) {
		super(msg, e);
	}
}
