package com.qa.RestAPI.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.JsonException;

import io.restassured.RestAssured;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.response.Response;

public class posts {
	
	public static int iPort = 3000;
	public  WireMockServer wireMockSever;
	
	/*@BeforeSuite
	public void setUpWireMockServer() throws Exception {
		
		wireMockSever = new WireMockServer(iPort);
		wireMockSever.start();
	}*/
	
	/*@BeforeTest
	public void getstubmappingsRequestAndResponse() {
		
		wireMockSever.stubFor(
	            get(urlEqualTo("/posts"))
	                .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
	                .willReturn(
	                    aResponse()
	                        .withStatus(200)
			                .withHeader("Content-Type", "application/json; charset=UTF-8")
	                        .withBodyFile("posts.json")
	                ));
	}*/

	
	@Test(enabled=false)
	public void getresponse() throws Throwable, Exception, JsonException{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		given().
		get().
		then().
		statusCode(200).
		log().all();
		
		Response response=
		given()
		.when()
		.get();
		
		System.out.println(response.asString());
		System.out.println(response.statusCode());
		System.out.println(response.getBody().asString());
	}
	
	@Test(priority=1)
	public void checkResponsefor_UserId() throws Throwable, Exception, JsonException{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		given().
		get().
		then().
		statusCode(200).
		log().all();
		
		Response response=
		given()
		.when()
		.get();
		
		System.out.println(response.asString());
		System.out.println(response.statusCode());
		List<Integer> li_userId=response.jsonPath().getList("userId");
		List<String> li_title=response.jsonPath().getList("title");
		int userId=7;
		for (int i = 0; i < li_userId.size(); i++) {
			if (li_userId.get(i).equals(userId)) {
				System.out.println("userId: "+li_userId.get(i).intValue());
				System.out.println("title: "+li_title.get(i).toString());
			}
		}
	}
		
	/*@AfterSuite
	public void teardown() {
		wireMockSever.stop();
	}*/
	

}
