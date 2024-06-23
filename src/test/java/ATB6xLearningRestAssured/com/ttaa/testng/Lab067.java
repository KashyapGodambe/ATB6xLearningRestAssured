package ATB6xLearningRestAssured.com.ttaa.testng;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;

public class Lab067 {
	
	@Description("TC#1(class67) - Verify get request 1")
	@Test
	public void getRequestSample1() 
	{
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking/1095")
		.when().get()
		.then().statusCode(200);
	}
	
	@Description("TC#2(class67) - Verify get request 2")
	@Test
	public void getRequestSample2() 
	{
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking/1199")
		.when().get()
		.then().statusCode(200);
	}

}
