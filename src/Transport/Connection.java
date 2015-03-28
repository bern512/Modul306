package Transport;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 
 * @author Patrick Krummen
 * @Version 0.1
 * @Date 24.03.2015
 *
 */

public class Connection {
	
	public static final String ZEICHENSATZ = "UTF-8";
	private Socket socket;
	private BufferedWriter output;
	
	
	public Connection(String host, int port) throws TransportException{
		this.newsoket(host,port);
		this.newoutputstream();
		
	}
	
	private void newsoket(String host, int port) throws TransportException{
		try{
			this.socket = new Socket(host,port);
		}catch(Exception e){
			throw new TransportException(e,"Verbindung zum Server konnte nicht hergestellt werden");
		}
	}
	
	private void newoutputstream() throws TransportException{
		try{
			this.output = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(),ZEICHENSATZ));
		}catch(Exception e){
			throw new TransportException(e,"Output Stram konnte nicht erstellt.");
		}
	}
	
	public void senden(String text) throws TransportException{
		try{
			this.output.write(text);
		}catch(Exception e){
			throw new TransportException(e,"Nachricht konnte nicht versendet werden");
		}
	}
	
	public void closesoket() throws TransportException{
		try{
			this.socket.close();
		}catch(Exception e){
			throw new TransportException(e,"Output Stram konnte nicht geschlossen werden");
		}
	}
	
	public Socket getSocket(){
		return this.socket;
	}
	
}
