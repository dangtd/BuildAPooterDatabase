package ca.sheridancollege;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.codehaus.jackson.map.ObjectMapper;

import ca.sheridancollege.beans.Comment;
import ca.sheridancollege.beans.User;

//try to use hard code first while waiting for client side which is getting Json data from other members because we are using two different techniques js and java
public class ProjectClient {

	public static void main(String[] args) {
	final int PORT = 50000;
	final String ADDRESS = "localhost";
    User user = new User("trandang", "12345","Dang", "Tran", "trandang123@yahoo.com", "123 Front", 123 );
	User userLogin = new User("trandang", "123");
    Comment comment = new Comment("This is a comment");
    ObjectMapper mapper = new ObjectMapper();
    try
    {
      String userLoginJson = mapper.writeValueAsString(user);
  	  String commentJson = mapper.writeValueAsString(comment);
  	  System.out.println(userLoginJson);
  	  
  	  Socket client = null;
	
  	  ObjectOutputStream out = null;
  	  ObjectInputStream in = null;
	
  	  client = new Socket(ADDRESS, PORT);
  	  out = new ObjectOutputStream(client.getOutputStream());
  	  in = new ObjectInputStream(client.getInputStream());
  	  
  	  System.out.println("Client Sending...");
  	  out.writeInt(1);
  	  out.writeObject(userLoginJson);
 
  	  out.flush();
  	  
  	  client.close();
	}
    catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
	
	
	
	

}
}
