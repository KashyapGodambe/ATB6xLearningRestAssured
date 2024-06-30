package ex_250624.RA_MISC;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class Lab083 {
	
	@Parameters("browser")
	@Test(priority=1)
	public void testDemo(String value)
	{
		System.out.println("The Value is : "+value);
		
		switch(value)
		{
		case "Chrome" : 
			System.out.println("Start & Run Chrome");
			//code for starting chrome
			break;
		case "Firefox" : 
			System.out.println("Start & Run Firefox");
			//code for starting Firefox
			break;
		case "Safari" : 
			System.out.println("Start & Run Safari");
			//code for starting Safari
			break;
		default : 
			System.out.println("Dont know what to run");
			break;	
		
		
		}
	}

}
