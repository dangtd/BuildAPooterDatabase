package ca.sheridancollege;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import ca.sheridancollege.beans.Build;
import ca.sheridancollege.beans.Comment;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.dao.DAO;


//service class where we receive and send data to client
public class ProjectService implements Runnable {
	private Socket me = null;
	public void run() {
		// TODO Auto-generated method stub
		
		//create DAO object
		DAO dao = new DAO();
		
		
		
		
		try {
			//create object mapper instance to use for json converts
			ObjectMapper mapper = new ObjectMapper();
			
			//get input and output stream to contact with client
			BufferedReader in = new BufferedReader(new InputStreamReader(me.getInputStream()));
			PrintWriter out = new PrintWriter(me.getOutputStream());

			
			System.out.println("checking the number");
			
			//read in option
			int option = Integer.parseInt(in.readLine());
			
			//json receive
			String jsonReceive = (String) in.readLine();
			
			//global userList
			List<User> userList = new ArrayList();
			
			
			switch(option){
				case 1:// create user
					
					//convert to java object
					User user = mapper.readValue(jsonReceive, User.class);
					
					//check user existence
					if(dao.checkUser(user.getEmail())){
						dao.insertUser(user);
						System.out.println("insert user");
						out.println(1);
						out.flush();
					}
					else{
						System.out.println("email existed");
						out.println(-1);
						out.flush();
					}	
					break;
				case 2://login
					User userLogin = mapper.readValue(jsonReceive, User.class);
					synchronized(User.class){
						userList = dao.login(userLogin.getUserName(), userLogin.getPassword());
						if(userList.isEmpty()){
							out.println(-1);
							System.out.println("Nothing found");
							out.flush();
						}
						else{
							String returnUserInfo = mapper.writeValueAsString(userList.get(0));
							out.println(returnUserInfo);
							out.flush();
							System.out.println("Welcome " + userList.get(0).getFirstName());
						}
					}
					break;
					
				case 3://insert comment
					Comment comment = mapper.readValue(jsonReceive, Comment.class);
					userList.get(0).getCommentList().add(comment);
					//need to have build ID to relate with comment
					dao.insertUser(userList.get(0));
					dao.insertComment(comment);
					out.println(1);
					out.flush();
					System.out.println("Welcome " + userList.get(0).getFirstName());
					break;
										
				case 4://insert build
					Build build = mapper.readValue(jsonReceive, Build.class);
					userList.get(0).getBuildList().add(build);
					dao.insertUser(userList.get(0));
					dao.insertBuild(build);
					out.println(1);
					out.flush();
					System.out.println("Welcome " + userList.get(0).getFirstName());				
					break;
				case 5://log out
					userList.clear();
					out.println(1);
					System.out.println("logged out");
					out.flush();
					break;
				
				
					
			}
			
			
			
			
			if(userList.isEmpty()){
				System.out.println("empty");
			}
			else{
				System.out.println(userList.get(0).getFirstName());
			}
			
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	public ProjectService(Socket me) {
		this.me = me;	
	}
}
