package ex_250624.RA_MISC;

import org.testng.annotations.Test;

public class Lab079 {
	//TestNG Priority in Java
	
	
	@Test(priority=1)
	public void testMethodOne()
	{
		System.out.println("Test Method One");
	}
	
	
	@Test(priority=2)
	public void testMethodTwo()
	{
		System.out.println("Test Method Two");
	}
	
	
	@Test(priority=0)
	public void testMethodZero()
	{
		System.out.println("Test Method Zero");
	}
	
	
	@Test(priority=-1)
	public void testMethodWithNegative()
	{
		System.out.println("Test Method Negative");
	}
	 

}
