package CustomExceptions;

public class RoomNotAvailableException extends RuntimeException {
	public RoomNotAvailableException (String msg){
		super(msg);
	}
}
