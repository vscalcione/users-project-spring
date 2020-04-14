package it.intersistemi.corso.users.dao.jdbc;

public class DataAccessException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -5353948412552073172L;

	public DataAccessException() {
		super();
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

}
