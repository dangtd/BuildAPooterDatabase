package ca.sheridancollege.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ca.sheridancollege.beans.Build;
import ca.sheridancollege.beans.Comment;
import ca.sheridancollege.beans.User;


public class DAO {
	Configuration configuration= new Configuration().configure();
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	public void insertUser(User user){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(user);
			
		session.getTransaction().commit();
		session.close();	
	}
	
	public void insertBuild(Build build){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(build);
			
		session.getTransaction().commit();
		session.close();	
	}
	
	public void insertComment(Comment comment){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(comment);
			
		session.getTransaction().commit();
		session.close();	
	}
	
	public List<User> login(String userNameLogin, String passwordLogin){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		Query query= session.getNamedQuery("User.login");
		query.setString("userName", userNameLogin);
		query.setString("password", passwordLogin);
		List<User> userList = (List<User>)query.list();
		
		session.getTransaction().commit();
		session.close();	
		
		
		return userList;
		
	}
	
	public boolean checkUser(String email){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query query= session.createQuery("from User where email = :email");
		query.setString("email", email);
		List<User> userList = (List<User>)query.list();
		boolean check;
		
		if(userList.isEmpty()){
			check = true;
		}
		else{
			check = false;
		}
		
		session.getTransaction().commit();
		session.close();	
		
		return check;

		
	}
	
	public List<Build> getBuildByUser(User user){
		Session session= sessionFactory.openSession();
		session.beginTransaction();

		Query query= session.createQuery("from Build INNER JOIN user_build ON user_build.buildList_buildId = Build.buildId WHERE user_build.user_email = :email");
		query.setString("email", user.getEmail());
		List<Build> buildList = (List<Build>)query.list();
		
		session.getTransaction().commit();
		session.close();	

		return buildList;
	}
	
	public List<Comment> getCommentByUser(User user){
		Session session= sessionFactory.openSession();
		session.beginTransaction();

		Query query= session.createQuery("from Comment INNER JOIN user_comment ON user_comment.commentList_commentId = Comment.commentId WHERE user_comment.user_email = :email");
		query.setString("email", user.getEmail());
		List<Comment> commentList = (List<Comment>)query.list();
		
		session.getTransaction().commit();
		session.close();	

		return commentList;
	}




	
}
