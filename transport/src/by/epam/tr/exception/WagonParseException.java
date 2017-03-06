package by.epam.tr.exception;

public class WagonParseException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WagonParseException(String message) {
		super (message);
	}
	
	public WagonParseException(String message, Throwable exception) {
		super (message, exception);
	}
}
