package kvstore;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class RequestHandler implements Runnable {
	private ServerSocket server;
	Socket socket = null; 
	private int port;
	DataInputStream in;
	
	
	public RequestHandler(ServerSocket server, int port) {
		super();
		this.server = server;
		this.port = port;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inside run");
		
		try {
			server = new ServerSocket(this.port); 
			
			
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            
            
	            String line = ""; 
	            try
                { 
                	
	            // reads message from client until "Over" is sent 
	            	while (true) 
	            	{ 
	            		socket = server.accept(); 
	                	System.out.println("Client accepted");
	        			in = new DataInputStream( new BufferedInputStream(socket.getInputStream())); 
	        	  
	                    line = in.readUTF(); 
	                    //line = in.readLine();
	                    System.out.println(line); 
	                    if(line.equals("Over")) break;
	  
	                
	                
	            	} 
                }
	            catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
	            System.out.println("Closing connection"); 
	  
	            // close connection 
	            in.close(); 
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

		}
		
		
	}
	public void stop() {
		try {
			if(in != null)
				in.close();
			if(!socket.isClosed())
				socket.close();
			if(!server.isClosed())
				server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}