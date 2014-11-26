/**
 *  Licenca Creative Commons
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.blog.exception;

/**
 * 
 *
 * @autor luciano
 * @version $Rev$ $Date$
 */
public class BlogException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3131826304594426472L;

	/**
	 * 
	 * @param message
	 */
	public BlogException( String message ){
		super( message );
	}

	/**
	 * 
	 * @param t
	 */
	public BlogException( Throwable t ){
		super( t );
	}
	
	/**
	 * 
	 * @param message
	 * @param t
	 */
	public BlogException( String message, Throwable t ){
		super(message, t);
	}

}
