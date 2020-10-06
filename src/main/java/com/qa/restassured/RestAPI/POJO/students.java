package com.qa.restassured.RestAPI.POJO;

import java.util.List;

public class students extends address{
	private String username;
	private String password;
	private List<Long> sessionid;
	private int id;
	private String name;
	private List<Integer> marks;
	private List<String> contact;
	private List<address> address;
	
	public void setUserName(String username) {
		this.username=username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setSessionID(List<Long> sessionid) {
		this.sessionid=sessionid;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setMarks(List<Integer> marks) {
		this.marks=marks;
	}
	public void setContact(List<String> contact) {
		this.contact=contact;
	}
	
	public void setAddress(List<address> address) {
		this.address=address;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<Long> getSessionID(){
		return sessionid;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Integer> getMarks(){
		return marks;
	}
	
	public List<String> getContact(){
		return contact;
	}
	
	public List<address> getAddress(){
		return address;
	}
	
	
}
