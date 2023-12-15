package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.tamplo.qa.utils.TestUtils;
import com.tamplo.qa.utils.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prob;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() throws IOException
	{
		
		try {
			
			prob = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prob.load(ip);
		} catch (FileNotFoundException r) 
		{
		r.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException r) 
		{
			r.printStackTrace();
		}
	}

	public static void  initialization() throws IOException 
	{
		
		String browsername = prob.getProperty("browser");
		String src = System.getProperty("user.dir");
		
		if(browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", src+"/src/test/resources/com/qa/drivers/chromedriver.exe");
			driver =  new ChromeDriver();
			
		}else 
			if (browsername.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", src+"/src/test/resources/com/qa/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else 
			
		if (browsername.equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "/src/test/resources/com/qa/drivers/IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MINUTES);
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(prob.getProperty("url"));
		
		
	}
	
	
}
