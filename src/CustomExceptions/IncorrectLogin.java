package CustomExceptions;

public class IncorrectLogin extends RuntimeException {
	public IncorrectLogin (String msg){
		super(msg);
	}
}
