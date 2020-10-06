package com.qa.restassured.RestAPI.POJO;


public class user {
	private int id;
	private int userId;
	private String title;
	private String body;
	
	public void setUserId(int userId) {
		this.userId=userId;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setBody(String body) {
		this.body=body;
	}
	
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}
}
