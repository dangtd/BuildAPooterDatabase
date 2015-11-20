package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SelectBeforeUpdate;

@DynamicUpdate
@SelectBeforeUpdate
@Entity
@NamedQuery(name="User.login", query="from User where userName=:userName and password=:password")
public class User implements Serializable {
	
	@Id
	private String email;
	private String userName, password, firstName, lastName, address;
	private int phone;
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {
		super();
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String password, String firstName, String lastName, String email,
			String address, int phone) {
		super();
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	
	@OneToMany(fetch=FetchType.EAGER )
	private List<Build> buildList = new ArrayList<Build>();
	public List<Build> getBuildList() {
		return buildList;
	}
	public void setBuildList(List<Build> buildList) {
		this.buildList = buildList;
	}
	

	@OneToMany(fetch=FetchType.EAGER )
	private List<Comment> commentList = new ArrayList<Comment>();
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
	
}
