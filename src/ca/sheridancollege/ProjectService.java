package ca.sheridancollege;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import ca.sheridancollege.beans.Comment;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.dao.DAO;


//service class where we receive and send data to client
public class ProjectService implements Runnable {
	private Socket me = null;
	public void run() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		try {
			ObjectMapper mapper = new ObjectMapper();
			
/*			ObjectInputStream in = new ObjectInputStream(me.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(me.getOutputStream());*/
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(me.getInputStream()));
			PrintWriter out = new PrintWriter(me.getOutputStream());

			
			System.out.println("checking the number");
			int option = Integer.parseInt(in.readLine());
			String jsonReceive = (String) in.readLine();
		
			switch(option){
				case 1:
					System.out.println("insert user");
					User user = mapper.readValue(jsonReceive, User.class);
					dao.insertUser(user);
					break;
				case 2:
					User userLogin = mapper.readValue(jsonReceive, User.class);
					List<User> userList= dao.login(userLogin.getUserName(), userLogin.getPassword());
					if(userList.isEmpty()){
						out.println("No user info");
						System.out.println("Nothing found");
						out.flush();
					}
					else{
						for (User u : userList) {	
							String userInfoJsonReturn = mapper.writeValueAsString(u);
							out.println(userInfoJsonReturn);
							out.flush();
							System.out.println("Welcome " + u.getFirstName());
						}
					}
					break;
				case 3:
					User userLogin1 = mapper.readValue(jsonReceive, User.class);
					List<User> userList1= dao.login(userLogin1.getUserName(), userLogin1.getPassword());
					if(userList1.isEmpty()){
						out.println("No user info");
						System.out.println("Nothing found");
						out.flush();
					}
					else{
						for (User u : userList1) {	
							List<Comment> commentList = dao.getCommentByUser(u);
							String returnComment = mapper.writeValueAsString(commentList);
							out.println(returnComment);
							out.flush();
							System.out.println("Welcome " + u.getFirstName());
						}
					}
					
				case 4:
					/*User userLogin2 = mapper.readValue(jsonReceive, User.class);
					List<User> userList2= dao.login(userLogin2.getUserName(), userLogin2.getPassword());
					if(userList2.isEmpty()){
						out.writeObject("No user info");
						System.out.println("Nothing found");
						out.flush();
					}
					else{
						for (User u : userList2) {	
							Build build = mapper.readValue(jsonReceive, Build.class);
							dao.insertBuild(build);
							u.getBuildList().add(build);
							dao.insertUser(u);
						}
					}
					*/
					break;
				case 5:
					/*User userLogin3 = mapper.readValue(jsonReceive, User.class);
					List<User> userList3= dao.login(userLogin3.getUserName(), userLogin3.getPassword());
					if(userList3.isEmpty()){
						out.println("No user info");
						System.out.println("Nothing found");
						out.flush();
					}
					else{
						for (User u : userList3) {	
							Comment comment = mapper.readValue(commentReceive, Comment.class);
							dao.insertComment(comment);
							u.getCommentList().add(comment);
							dao.insertUser(u);
						}
					}*/
					
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
