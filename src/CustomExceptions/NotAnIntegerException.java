package CustomExceptions;

public class NotAnIntegerException extends RuntimeException {
	public NotAnIntegerException (String msg){
		super(msg);
	}
}
