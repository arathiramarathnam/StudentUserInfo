package com.qa.RestAPI.tests;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.restassured.RestAPI.POJO.address;
import com.qa.restassured.RestAPI.POJO.students;

public class UserInfo {
	
	JSONParser parser=new JSONParser();

	@Test(priority=1)
	public void user_name() throws Throwable, Exception, ParseException{
		
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase1: find value of username------->");
			
		String username=(String) jsonObject.get("username");
		System.out.println("username: "+username);
	}
	
	
	@Test(priority=2)
	public void session_id() throws Throwable, Exception, ParseException{
		
		try {
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase2: find values of sessionID------->");
			
		JSONArray session_id=(JSONArray) jsonObject.get("sessionid");
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> it=session_id.iterator();
		System.out.print("sessionid: [");
		while (it.hasNext()) {
			System.out.print(it.next()+", ");
		}
		System.out.println("]");
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void session_id_LastValue() throws Throwable, Exception, ParseException{
		
		try {
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase3: find last value of sessionID------->");
				
		JSONArray session_id=(JSONArray) jsonObject.get("sessionid");
		long firstvalue = (Long) session_id.get(0); 
//		System.out.println("first value of session_id: "+firstvalue);
		long lastvalue=(Long) session_id.get(session_id.size()-1);
		System.out.println("last value of session_id: "+lastvalue);
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void allmarksof_SecondStudent() throws Throwable, Exception, ParseException{
		
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase4: find all marks of secondstudent------->");
			
		JSONArray students=(JSONArray) jsonObject.get("students");
		if (students!=null) {
			students stud =mapper.readValue(students.get(1).toString(), students.class);
			System.out.println("marks: "+stud.getMarks().toString());
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public void secondstate_valueof_FirstStudent() throws Throwable, Exception, ParseException{
		
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase5: find second state value of secondstudent------->");
			
		JSONArray students=(JSONArray) jsonObject.get("students");
		if (students!=null) {
			students stud =mapper.readValue(students.get(0).toString(), students.class);
			
			System.out.println("state: "+stud.getAddress().get(1).getState().toString());
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test(priority=6)
	public void secondcontact_valueof_SecondStudent() throws Throwable, Exception, ParseException{
		
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase6: find second contact value of secondstudent------->");
			
		JSONArray students=(JSONArray) jsonObject.get("students");
		if (students!=null) {
			students stud =mapper.readValue(students.get(1).toString(), students.class);
			System.out.println("contact: "+stud.getContact().get(1).toString());
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	@Test(priority=7)
	public void allcitiesof_SecondStudent() throws Throwable, Exception, ParseException{
		
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase7: find all cities of secondstudent------->");
			
		JSONArray students=(JSONArray) jsonObject.get("students");
		if (students!=null) {
			students stud =mapper.readValue(students.get(1).toString(), students.class);
			System.out.println("city: ["+stud.getAddress().get(0).getCity().toString()+","+stud.getAddress().get(1).getCity().toString()+"]");
		}		
		/**JSONArray address=(JSONArray) jsonObject.get("address");
		if (address!=null) {
			address addr=mapper.readValue(address.get(1).toString(), address.class);
			System.out.println("city: "+addr.getCity().toString());
		}**/
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test(priority=8)
	public void contactsof_allStudents() throws Throwable, Exception, ParseException{
		
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase8: find contacts of all students------->");
			
		JSONArray students=(JSONArray) jsonObject.get("students");
		if (students!=null) {
			students stud =mapper.readValue(students.get(0).toString(), students.class);
			System.out.println("contact[0]: "+stud.getContact().toString());
//readValue(String content, class<>valuetype): Method to deserialize JSON content from given JSON content String.
			students stud1 =mapper.readValue(students.get(1).toString(), students.class);
			System.out.println("contact[1]: "+stud1.getContact().toString());
			
			students stud2 =mapper.readValue(students.get(2).toString(), students.class);
			System.out.println("contact[2]: "+stud2.getContact().toString());
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test(priority=9)
	public void addressof_firstStudent() throws Throwable, Exception, ParseException{
		
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object obj= parser.parse(new FileReader("C:\\Users\\arath\\eclipse\\com.qa.restassured.RestAPI.UserInfo\\src\\test\\resources\\__files\\userinfo.json"));
		JSONObject jsonObject=(JSONObject) obj;
		System.out.println("<-------Testcase9: find address of first student------->");
			
		JSONArray students=(JSONArray) jsonObject.get("students");
		if (students!=null) {
			students stud =mapper.readValue(students.get(0).toString(), students.class);
			System.out.print("address: [{state:"+stud.getAddress().get(0).getState().toString()+",city:"+stud.getAddress().get(0).getCity().toString()+"},");
			System.out.println("{state:"+stud.getAddress().get(1).getState().toString()+",city:"+stud.getAddress().get(1).getCity().toString()+"}]");
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
}
