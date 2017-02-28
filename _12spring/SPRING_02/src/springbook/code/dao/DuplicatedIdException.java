package springbook.code.dao;

public class DuplicatedIdException extends RuntimeException {

	public DuplicatedIdException(Throwable cause) {
		super("어아어엉"+cause);
	}
}
