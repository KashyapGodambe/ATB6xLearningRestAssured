package ex_220624.CRUD.PUT;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab075 {
	
	RequestSpecification rs =  RestAssured.given();;
	Response response;
	ValidatableResponse vr;
	String token = "78e5c9c49f3002e";
	String bookingId = "4442";
	
	String base_Url = "https://restful-booker.herokuapp.com";
	String base_Path = "/booking";
	
	
	
	@Test
	public void testPutRequestNonBDD()
	{
		String base_Path_Updated = base_Path + "/4442";
		System.out.println(base_Path_Updated);
		
		String Payload = "{\r\n"
				+ "    \"firstname\" : \"Sujawala\",\r\n"
				+ "    \"lastname\" : \"Moreeeee\",\r\n"
				+ "    \"totalprice\" : 421,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2023-01-01\",\r\n"
				+ "        \"checkout\" : \"2024-05-05\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast, ProteinShake\"\r\n"
				+ "}";
		
		
		
		rs.basePath(base_Url);
		rs.basePath(base_Path_Updated);
		rs.contentType(ContentType.JSON);
		rs.cookie("token", token);
		rs.body(Payload).log().all();
		
		
		response = rs.when().log().all().put();
	}
	

}
