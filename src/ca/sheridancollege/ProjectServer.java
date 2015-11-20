package ca.sheridancollege;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//this is the server where we use to connect to client
public class ProjectServer {
	public static void main(String[] args) {

		final int PORT = 50000;
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			Socket client = null;
			try {
				client = server.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread t = new Thread(new ProjectService(client));
			System.out.println("socket connected");
			t.start();
		}
		
	}
}
