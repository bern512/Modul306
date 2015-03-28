package Transport;

public class TransportException extends Exception {
	
	private Exception e;
	private String error;
	
	public TransportException(Exception e, String error){
		this.e = e;
		this.error = error;
	}
}
