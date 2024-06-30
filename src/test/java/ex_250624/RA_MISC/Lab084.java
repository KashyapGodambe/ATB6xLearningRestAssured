package ex_250624.RA_MISC;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Lab084 {
	
	
	@DataProvider
	public Object [][] getData()
	{
		Faker faker = new Faker();
		String username= faker.name().fullName();
		String password = faker.internet().password();
		
		return new Object[][] {
			new Object[] {username , password},
			new Object[] {"Admin" , "admin"},
			new Object[] {"Admin" , "Password123"},
		};
		
	} //in real life we dont use this.
	
	
	@DataProvider
	public Object [][] getDataFromExcel()
	{
		//Apache POI code
		//Read excel file > which contains data & give it to the getData function/method
		return null;
		
	} 
	
	
	
	@Test(dataProvider = "getData")
	public void testAuthToGetToken(String username, String password)
	{
		System.out.println(username);
		System.out.println(password);
		
		//Rest Assured Logic
	}

}
