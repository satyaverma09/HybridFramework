package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By user= By.id("email1");
	By pass= By.id("password1");
	By login= By.xpath("//button[normalize-space()='Sign in']");
	
	public void LoginToApplication(String username, String userpass)
	{
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).sendKeys(userpass);
		driver.findElement(login).click();
	}

}
