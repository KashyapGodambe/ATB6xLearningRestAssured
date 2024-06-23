package ATB6xLearningRestAssured.com.ttaa;

import io.restassured.RestAssured;

public class Lab066 {

	public static void main(String[] args) {
		// TODO Sample program of RestAssured
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking/1866")
		.when().get()
		.then().statusCode(404);

	}

}
