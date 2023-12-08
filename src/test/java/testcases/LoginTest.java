package testcases;

import org.testng.annotations.Test;

import base.baseclass;
import dataProvider.sampletestDDT;
import pages.LoginPage;

public class LoginTest extends baseclass{
	
	@Test(dataProvider = "LoginDetails",dataProviderClass =sampletestDDT.class)
	public void LoginToApplication(String uname, String upass) 
	{
		LoginPage login = new LoginPage(driver);
		login.LoginToApplication(uname, upass);
		//Thread.sleep(3000);
		//Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).isDisplayed());
		//driver.quit();
	}

}
