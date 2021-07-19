package app.clothesstore.productos.exceptions;

public class ObjectAllreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4050307613379424311L;

	public ObjectAllreadyExistException() {
		super();
	}

	public ObjectAllreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ObjectAllreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectAllreadyExistException(String message) {
		super(message);
	}

	public ObjectAllreadyExistException(Throwable cause) {
		super(cause);
	}
}
