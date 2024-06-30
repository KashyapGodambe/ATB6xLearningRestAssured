package ex_250624.RA_MISC;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Lab080 {
	
	//Grouping of testcases
	
	
	//If there are 100 test cases then,
	//P0=20, P1=30, P2=50
	//40=Smoke, 60=Sanity Testcases
	
	
	@Issue("TC123")
	@Severity(SeverityLevel.MINOR)
	//@Description("TC#1 - Verify that create booking is working with valid payload")
	@Description("TC#1 - Sanity test case")
	@Test(groups = {"sanity"})
	public void sanityRun()
	{
		System.out.println("Sanity test");
		System.out.println("QA QA");
	}
	
	
	@Description("TC#2 - Regression test case")
	@Test(groups = {"Regression"})
	public void regressionRun()
	{
		System.out.println("Regression test");
	}
	
	@Description("TC#3 - Smoke test case")
	@Test(groups = {"Prod", "sanity"})
	public void smokeRun()
	{
		System.out.println("Smoke test");
	}
	
	
	@Description("TC#4 - Production test case")
	@Test(groups = {"Prod"})
	public void prodRun()
	{
		System.out.println("Production test");
	}

}
