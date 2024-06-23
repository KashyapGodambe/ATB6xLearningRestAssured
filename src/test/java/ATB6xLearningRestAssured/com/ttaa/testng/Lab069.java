package ATB6xLearningRestAssured.com.ttaa.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab069 {
//	Create booking - id
//	Create Auth - token
//	PUT - id, token
//	Delete - id
//	GET - Id > verify it shouldnt exist
	
	
	
	String token;
	Integer bookingId;
	
	public String getToken()
	{
		token = "123";
		return token;
		
	}
	
	@BeforeTest
	public void getTokenAndBookingId()
	{
		token = getToken();
		bookingId = 123;
		//POST Req will be done 
	}
	
	
	@Test
	public void testPutRequest()
	{
		System.out.println(token);
		System.out.println(bookingId);
		//PUT Request Code
		
	}
	
	@Test
	public void testDeleteRequest()
	{
		System.out.println(token);
		System.out.println(bookingId);
		//DELETE Request Code
		
	}
	
	
	@Test
	public void testGetRequest()
	{
		
		System.out.println(bookingId);
		//GET Request Code
		
	}
	
	
	

}
