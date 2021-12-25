package CustomExceptions;

public class IncorrectEmailFormat extends RuntimeException {
	public IncorrectEmailFormat (String msg){
		super(msg);
	}
}
