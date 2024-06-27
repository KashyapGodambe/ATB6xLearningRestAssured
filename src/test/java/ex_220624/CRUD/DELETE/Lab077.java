package ex_220624.CRUD.DELETE;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab077 {
	
	RequestSpecification rs =  RestAssured.given();;
	Response response;
	ValidatableResponse vr;
	String token = "8f997d2b226919a";
	String bookingId = "668";
	
	String base_Url = "https://restful-booker.herokuapp.com";
	String base_Path = "/booking";
	
	
	
	@Test
	public void testDeleteRequestNonBDDPostive()
	{
		String base_Path_Updated = base_Path + "/"+bookingId;
		System.out.println(base_Path_Updated);
		
		
		
		
		rs.baseUri(base_Url);
		rs.basePath(base_Path_Updated);
		rs.contentType(ContentType.JSON);
		rs.cookie("token", token);
		rs.log().all();
		
		
		response = rs.when().log().all().delete();
		
		
		vr = response.then().log().all();
		vr.statusCode(201);
	}
	
	
}
