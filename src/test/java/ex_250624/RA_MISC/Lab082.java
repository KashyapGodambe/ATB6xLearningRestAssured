package ex_250624.RA_MISC;

import org.testng.annotations.Test;

public class Lab082 {
	
	//using groups & dependOnGroups
	
	@Test(groups={"init"}, priority=1)
	public void getAToken()
	{
		System.out.println("------ServerStarted------");
		
	}
	
	
	@Test(groups={"init"}, priority=2)
	public void getBookingId()
	{
		
		System.out.println("------InitiatedEnvironment------");
	}
	
	
	
	@Test(dependsOnGroups = {"init.*"})	
	public void testPutRequest()
	{
		
		System.out.println("------Now I will UPDATE the request------");
	}
	
	
	
	@Test(dependsOnGroups = {"init.*"})
	public void testDeleteRequest()
	{
		System.out.println("------Now I will DELETE the request------");
		
	}
	

}
