package ex_220621.FULL.CRUD;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab078 {
	
	//FULL CRUD operation
	
	String token;
	Integer bookingId;
	RequestSpecification requestSpecification = RestAssured.given();
	Response response;
	ValidatableResponse validatableResponse;
	
	
	@BeforeTest
	public void getAToken()
	{
		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/auth");
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payload);
		
		response = requestSpecification.when().post();
		validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
		//Now extract the token from this
		
		token = response.then().log().all().extract().path("token");
		Assert.assertNotNull(token);
		
	}
	
	
	@BeforeTest
	public void getBookingId()
	{
		String payload = "{\r\n"
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
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking");
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payload);
		
		response = requestSpecification.when().post();
		validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
		//Now extract the BookingId from this
		
		bookingId = response.then().log().all().extract().path("bookingid");
		System.out.println("------Booking id is : ------"+bookingId);
		Assert.assertNotNull(bookingId);
		
	}
	
	
	@Test
	public void testPutRequestPositive()
	{
		
		String payload = "{\r\n"
				+ "    \"firstname\" : \"Sujawalla\",\r\n"
				+ "    \"lastname\" : \"Goree\",\r\n"
				+ "    \"totalprice\" : 420,\r\n"
				+ "    \"depositpaid\" : false,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2023-01-01\",\r\n"
				+ "        \"checkout\" : \"2024-02-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast, Lunch\"\r\n"
				+ "}";
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking/"+bookingId);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.cookie("token", token);
		
		//PUT req
		requestSpecification.body(payload).log().all();
		
		response = requestSpecification.when().put();
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
		
		//Now extract the token from this
		
		String firstNameResponse = response.then().log().all().extract().path("firstname");
		System.out.println("------firstName_Response is : ------"+firstNameResponse);
		Assert.assertEquals(firstNameResponse, "Sujawalla");
		
		
		String fullReponseJSONString = response.asString();
		System.out.println("------Full_Response is : ------"+fullReponseJSONString);
		
		//Verify all key & value pairs in response
		
		//3 Ways to verify the response
		//1. RA - Matchers
		validatableResponse.body("firstname", Matchers.equalTo("Sujawalla"));
		validatableResponse.body("lastname", Matchers.equalTo("Goree"));
		
		//2.TestNg assertions 
		String firstNameResponse1 = response.then().log().all().extract().path("firstname");
		Assert.assertEquals(firstNameResponse1, "Sujawalla");

		//3.TestNG assertions with JSON Path lib
		JsonPath jsonPath = new JsonPath(fullReponseJSONString);
		String firstNameJsonPathExtracted = jsonPath.getString("firstname");
		String lastNameJsonPathExtracted = jsonPath.getString("lastname");
		int totalPriceJsonPathExtracted = jsonPath.getInt("totalprice");
		//Integer totalPriceJsonPathExtracted = jsonPath.getInt("totalprice");
		System.out.println(totalPriceJsonPathExtracted);
		String checkInDateJsonPathExtracted = jsonPath.getString("bookingdates.checkin");
		
		
		Assert.assertEquals(firstNameJsonPathExtracted, "Sujawalla");
		Assert.assertEquals(lastNameJsonPathExtracted, "Goree");
		//Assert.assertEquals(totalPriceJsonPathExtracted, 420);
		Assert.assertEquals(totalPriceJsonPathExtracted, 420);
		Assert.assertEquals(checkInDateJsonPathExtracted, "2023-01-01");
		
		
		//4.AssertJ assertions
		assertThat(firstNameJsonPathExtracted).isEqualTo("Sujawalla").isNotEmpty().isNotBlank().contains("Suj");
		assertThat(totalPriceJsonPathExtracted).isNotZero().isNotNegative();
		
		
		
		
	}
	

}
