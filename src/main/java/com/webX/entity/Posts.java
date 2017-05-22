package com.webX.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;





@Entity
public class Posts {

	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Size(min=4, max=15, message="author must be at least 4 characters!")
	private String author;
	
	@Column(columnDefinition="TEXT")
	private String body;

	private Date publishdate;

	@Size(min=4,max=20, message="Title must be at least 4 characters!")
	private String title;
	
	


	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;

	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

}
