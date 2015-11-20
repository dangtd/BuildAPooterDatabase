package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@DynamicUpdate
@SelectBeforeUpdate
@Entity
public class Comment implements Serializable {
	@Id
	@GeneratedValue
	private int commentId;
	private String commentDetail;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentDetail() {
		return commentDetail;
	}
	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
	public Comment(String commentDetail) {
		super();
		this.commentDetail = commentDetail;
	}
	public Comment() {
		super();
	}
	
}
