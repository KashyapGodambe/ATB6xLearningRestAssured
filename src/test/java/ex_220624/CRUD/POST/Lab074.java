package ex_220624.CRUD.POST;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab074 {
	String base_Url = "https://restful-booker.herokuapp.com";
	String base_Path = "/booking";
	String Payload = "{\r\n"
			+ "    \"firstname\" : \"Manav\",\r\n"
			+ "    \"lastname\" : \"Mane\",\r\n"
			+ "    \"totalprice\" : 520,\r\n"
			+ "    \"depositpaid\" : false,\r\n"
			+ "    \"bookingdates\" : {\r\n"
			+ "        \"checkin\" : \"2023-01-01\",\r\n"
			+ "        \"checkout\" : \"2024-02-01\"\r\n"
			+ "    },\r\n"
			+ "    \"additionalneeds\" : \"Breakfast, Lunch, Dinner\"\r\n"
			+ "}";
	
	String Payload2 = "{}";
	 
	RequestSpecification r = RestAssured.given();
	Response response;
	ValidatableResponse validatableResponse;
	
	
	@Description("TC#1 - Verify that create booking is working with valid payload")
	@Test
	public void testPostRequestNonBDDPositive()
	{
		//Create Booking
		
		//POST Request 
		//URL
		//Body - JSON payload
		//Header - Content type
		
		
		r.baseUri(base_Url);
		r.basePath(base_Path);
		r.contentType(ContentType.JSON).log().all();
		r.body(Payload);
		
		response = r.when().log().all().post();
		String reponseString = response.asString();
		System.out.println(reponseString);
		
		validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
		
	}
	
	
	@Description("TC#2 - Verify that create booking is not working with invalid payload with 500 error")
	@Test
	public void testPostRequestNonBDDNegative()
	{
		//Create Booking
		
		r.baseUri(base_Url);
		r.basePath(base_Path);
		r.contentType(ContentType.JSON).log().all();
		r.body(Payload2);
		
		response = r.when().log().all().post();
		String reponseStringNegative1 = response.asString();
		System.out.println("Data for negative sceanrio : "+reponseStringNegative1);
		
		validatableResponse = response.then();
		validatableResponse.statusCode(500);
		
		
	}

}
