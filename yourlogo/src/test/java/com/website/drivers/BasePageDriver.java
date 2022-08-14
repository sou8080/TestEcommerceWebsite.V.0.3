package com.website.drivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageDriver 
{
	public WebDriverWait driverwait;
	public WebDriver driver;
	public BasePageDriver() 
	{
		try 
		{
			InputStream inputstream = new FileInputStream("C:\\Users\\Tania\\Desktop\\Souvik_Data\\yourlogo\\src\\test\\resources\\com\\website\\files\\webdriver.properties");
		
			Properties p = new Properties();
			driver= null;
	
			p.load(inputstream);
			String browser = p.getProperty("browser");
			System.out.println("Currently the browser we are using is " + browser);
			
			if(browser!= null && browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Tania\\Desktop\\webdrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
			}
			else if (browser!= null && browser.equals("edge")) 
			{
				System.setProperty("webdriver.edge.driver","C:\\Users\\Tania\\Desktop\\webdrivers\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void takescreenshot(String name) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:/Users/Tania/Desktop/Souvik_Data/yourlogo/src/test/resources/com/website/screenshots/"+ name +".png"));
	}
	public void close()
	{
	 driver.close();	
	}
}
