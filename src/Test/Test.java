package Test;

import Transport.Connection;
import Transport.TransportException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Connection co = new Connection("localhost",100);
		}catch(TransportException e){
			System.out.println(e);
		}
	}

}
