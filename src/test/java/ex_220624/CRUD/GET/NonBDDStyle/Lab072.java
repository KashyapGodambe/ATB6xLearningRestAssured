package ex_220624.CRUD.GET.NonBDDStyle;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab072 {
	//
	
	@Test
	public void getRequestPositive()
	{
		RequestSpecification r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/1207");
		
		r.when().get();
		
		r.then().log().all().statusCode(200);
		
		//Header, response data/body
		
	}
	
	@Test
	public void getRequestNegative()
	{
		RequestSpecification r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/-1");
		
		r.when().get();
		
		r.then().log().all().statusCode(404);
		
		//Header, response data/body
		
	}
	

}
