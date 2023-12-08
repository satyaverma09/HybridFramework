package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.testng.Reporter;

public class browserfactory {
	
	public static WebDriver startBrowser(String browsername, String applicationurl)
	{
		WebDriver driver= null;
		if(browsername.contains("Chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(browsername.contains("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.contains("Safari"))
		{
			driver = new SafariDriver();
		}
		else if(browsername.contains("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			//Reporter.log("Sorry"+browsername + "is not supported so running in default browser");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(applicationurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
