package ca.owenpeterson.exception;

public class CommandOutputException extends Exception {

	private static final long serialVersionUID = -7646845715974692731L;

	public CommandOutputException() {
		// TODO add messages to exception class.
	}

	public CommandOutputException(String message) {
		super(message);
	}

	public CommandOutputException(Throwable cause) {
		super(cause);
	}

	public CommandOutputException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandOutputException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
