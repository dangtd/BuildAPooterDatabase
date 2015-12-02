package ca.sheridancollege;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
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
			/* mapper.setPropertyNamingStrategy(new MyNameStrategy());*/
			/*mapper.configure(
					DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);*/
			
			//get input and output stream to contact with client
			BufferedReader in = new BufferedReader(new InputStreamReader(me.getInputStream()));
			PrintWriter out = new PrintWriter(me.getOutputStream());

			
			System.out.println("checking the number");
			
			//read integer option
			int option = Integer.parseInt(in.readLine());
			
			//json receive
			String jsonReceive = (String) in.readLine();
			
			
			
			//create instance of list of user and user object
			List<User> userList = new ArrayList();
			User user = new User();
			
			switch(option){
				case 1:// create user			
					user = mapper.readValue(jsonReceive, User.class);
					//check user existence
					if(dao.checkUser(user.getEmail())){
						//if not exist, insert user
						dao.insertUser(user);
						System.out.println("insert user");
						
						//determine user inserted
						out.print(1);
						out.flush();
					}
					else{
						System.out.println("email existed");
						//if exist, determine user existed
						out.print(-1);
						out.flush();
					}
					user = null;
					break;
					
				case 2://login
					user = mapper.readValue(jsonReceive, User.class);
					userList = dao.login(user.getUserName(), user.getPassword());
					if(userList.isEmpty()){
						out.print(-1);
						System.out.println("Nothing found");
						out.flush();
					}
					else{
						String returnUserInfo = mapper.writeValueAsString(userList.get(0));
						out.print(returnUserInfo);
						out.flush();
						System.out.println("Welcome " + userList.get(0).getFirstName());
					}
					user = null;
					userList.clear();
					break;
					
				case 3://insert comment
					Comment comment = mapper.readValue(jsonReceive, Comment.class);
					User userLogin = mapper.readValue(jsonReceive, User.class);
					userList = dao.login(userLogin.getUserName(), userLogin.getPassword());
					userList.get(0).getCommentList().add(comment);
					//need to have build ID to relate with comment
					dao.insertUser(userList.get(0));
					dao.insertComment(comment);
					out.print(1);
					out.flush();
					System.out.println("comment inserted");
					user = null;
					userList.clear();
					break;
										
				case 4://insert build
					//convert build json to java object
					
					Build build = mapper.readValue(jsonReceive, Build.class);
					
					//take in user email to search for user
					String userEmail = (String)in.readLine();
					
					
					
					System.out.println(userEmail);
					
					
					
					
					//get user info
					user = dao.getUserByEmail(userEmail);
					
					//add build to user's build
					user.getBuildList().add(build);
					
					//insert build
					dao.insertBuild(build);
					
					//update user
					dao.insertUser(user);
					System.out.println("aaaa");
					
					
					//determine build is inserted
					out.print(1);
					out.flush();
					System.out.println("build inserted");	
					user = null;
					userList.clear();
					break;			
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
