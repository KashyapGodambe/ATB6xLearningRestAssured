package ex_220624.CRUD.GET.BDDStyle;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab072 {
	//
	
	@Test
	public void testGetRequestPostiveBDDStyle()
	{
		RequestSpecification r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/1207");
		
		r.when().log().all().get();
		
		r.then().log().all().statusCode(200);
		
		//Header, response data/body
		
	}
	
	@Test
	public void testGetRequestNegativeBDDStyle()
	{
		RequestSpecification r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/-1");
		
		r.when().log().all().get();
		
		r.then().log().all().statusCode(404);
		
		//Header, response data/body
		
	}
	

}
