package ex_250624.RA_MISC.Listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomeListener.class)
public class Lab084 {
	
	
	@Test(groups = "sanity")
	public void test1()
	{
		System.out.println("test 1");
		Assert.assertTrue(false);
	}
	
	
	@Test(groups = "sanity")
	public void test2()
	{
		System.out.println("test 2");
		Assert.assertTrue(true);
	}
	
	
	@AfterSuite
	public void sendReportToQALEad()
	{
		System.out.println("Send report to QA lead");
	}

}
