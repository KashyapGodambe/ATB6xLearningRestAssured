package ex_220624.CRUD.POST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Lab073 {
	
	
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
	 
	
	
	@Test
	public void testPostRequestBDDPositive()
	{
		//Create Booking
		
		//POST Request 
		//URL
		//Body - JSON payload
		//Header - Content type
		
		RestAssured
		.given()
		.baseUri(base_Url).basePath(base_Path).contentType(ContentType.JSON).log().all().body(Payload)
		
		.when().log().all().post()
		
		.then().log().all().statusCode(200);
		
		
	}

}
