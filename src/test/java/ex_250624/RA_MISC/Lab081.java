package ex_250624.RA_MISC;

import org.testng.annotations.Test;

public class Lab081 {
	
	
	@Test
	public void getAToken()
	{
		System.out.println("------I will get you the TOKEN------");
		
	}
	
	
	@Test
	public void getBookingId()
	{
		
		System.out.println("------I will get you the BOOKING ID------");
	}
	
	
	
	@Test(dependsOnMethods = {"getAToken" , "getBookingId"})
	public void testPutRequest()
	{
		
		System.out.println("------I will UPDATE the request------");
	}
	
	
	
	@Test(dependsOnMethods = {"getAToken" , "getBookingId"})
	public void testDeleteRequest()
	{
		System.out.println("------I will DELETE the request------");
		
	}

}
