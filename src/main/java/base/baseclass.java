package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browserFactory.browserfactory;
import dataProvider.ConfigReader;

public class baseclass {
	
public WebDriver driver;
	
	@BeforeMethod
	public void setupBrowser()
	{
		System.out.println("Log: Setting up browser");
		driver=browserfactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("url"));
		System.out.println("Log: Browser is Up and Running");
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
		System.out.println("Log: Closing the browser");
	}

}
