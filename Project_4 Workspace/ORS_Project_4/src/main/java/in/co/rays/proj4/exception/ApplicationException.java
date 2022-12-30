package in.co.rays.proj4.exception;

/*
 * Application Exception is Propogeted from Service Classes when a business
 * logic exception occured
 * @author Sonali
 * @version 1.0
 * @Copyright(c) Sonali
 */

public class ApplicationException extends Exception {
	
   //	@param msg : Error message
	
	public ApplicationException(String msg) {
		super(msg);
	}
	
}
