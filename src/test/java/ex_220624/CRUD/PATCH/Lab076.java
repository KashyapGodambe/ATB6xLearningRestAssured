package ex_220624.CRUD.PATCH;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab076 {
	
	RequestSpecification rs =  RestAssured.given();;
	Response response;
	ValidatableResponse vr;
	String token = "8f997d2b226919a";
	String bookingId = "668";
	
	String base_Url = "https://restful-booker.herokuapp.com";
	String base_Path = "/booking";
	
	
	
	@Test
	public void testPatchRequestNonBDDPostive()
	{
		String base_Path_Updated = base_Path + "/"+bookingId;
		System.out.println(base_Path_Updated);
		
		String Payload = "{\r\n"
				+ "    \"firstname\" : \"Harshal\",\r\n"
				+ "    \"lastname\" : \"Markanday\"\r\n"
				+ "}";
		
		
		
		rs.baseUri(base_Url);
		rs.basePath(base_Path_Updated);
		rs.contentType(ContentType.JSON);
		rs.cookie("token", token);
		rs.body(Payload).log().all();
		
		
		response = rs.when().log().all().patch();
		
		
		vr = response.then().log().all();
		vr.statusCode(200);
		
		vr.body("firstname", Matchers.equalTo("Harshal"));
		vr.body("lastname", Matchers.equalTo("Markanday"));
		
		
		
		
	}

}
