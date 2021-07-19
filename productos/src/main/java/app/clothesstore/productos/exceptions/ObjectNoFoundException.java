package app.clothesstore.productos.exceptions;

public class ObjectNoFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4071785098817490289L;

	public ObjectNoFoundException() {
		super();
	}

	public ObjectNoFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ObjectNoFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNoFoundException(String message) {
		super(message);
	}

	public ObjectNoFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
