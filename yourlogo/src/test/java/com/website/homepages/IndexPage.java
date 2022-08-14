package com.website.homepages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.website.drivers.BasePageDriver;

public class IndexPage extends BasePageDriver
{
	protected WebElement testSignIn;
	
	public void indexPageSignUp() 
	{
		
		driverwait = new WebDriverWait(driver, Duration.ofMillis(8000));
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
		driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("login")));
		testSignIn = driver.findElement(By.className("login"));
		
		testSignIn.click();	
		
	}
}
