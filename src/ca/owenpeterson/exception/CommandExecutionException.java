package ca.owenpeterson.exception;

public class CommandExecutionException extends Exception {

	private static final long serialVersionUID = -5390271322839062206L;

	public CommandExecutionException() {
		super();
	}

	public CommandExecutionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		//TODO: move messages to exception class.
	}

	public CommandExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandExecutionException(String message) {
		super(message);
	}

	public CommandExecutionException(Throwable cause) {
		super(cause);
	}
	
	
	
	

}
