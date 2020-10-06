package com.qa.restassured.RestAPI.POJO;

public class address {
	private String state;
	private String city;
	
	public void setState(String state) {
		this.state=state;
	}
	
	public String getState() {
		return state;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getCity() {
		return city;
	}
}
