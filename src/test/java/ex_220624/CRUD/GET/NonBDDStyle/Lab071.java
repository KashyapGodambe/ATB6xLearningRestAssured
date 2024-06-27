package ex_220624.CRUD.GET.NonBDDStyle;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab071 {
	
	@Test 
	public void testGetRequestNonBDDStyle()
	{
		RequestSpecification rs = RestAssured.given();
		
		rs.baseUri("https://restful-booker.herokuapp.com");
		rs.basePath("/booking/4462");
		
		
		
		rs.when().log().all().get();

		rs.then().log().all().statusCode(200);
		
				
	}

}
