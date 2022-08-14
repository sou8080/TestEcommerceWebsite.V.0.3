package com.website.LoginPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.website.homepages.IndexPage;

public class LoginPage extends IndexPage
{
	private WebElement textUsername;
	private WebElement textPassword;
	private WebElement btnSubmit;
	
	public void login() throws InterruptedException 
	{
		try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","sou1234");  
		
				System.out.println("connect to db");  
		
				String sql = "SELECT * FROM testingdb.souviklogin";		
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
		
				while(rs.next())
				{	
					driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email")));
					textUsername = driver.findElement(By.id("email")); // Finding Element by id 
					textUsername.sendKeys(rs.getString(1));  // sending keys through databases
				
					Thread.sleep(2000);
				
					driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("passwd")));
					textPassword = driver.findElement(By.name("passwd")); 	// Finding element by name 
					textPassword.sendKeys(rs.getString(2));  	// sending keys through databases
			
					driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("SubmitLogin"))); // waiting for button element to click 		
					btnSubmit = driver.findElement(By.name("SubmitLogin"));
					btnSubmit.click();
				
					driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
					if (rs.getString(1).contentEquals("xyzsou@gmail.com") && rs.getString(2).contentEquals("NOTONLY")) 
					{
						break;
					}
					else
					{
						try
						{
							driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email")));
							Thread.sleep(2000);
							textUsername.clear();	 // To clear the text in the username textbox
				
							driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("passwd")));
							Thread.sleep(2000);
							textPassword.clear(); 	// To clear the text in password textbox					
						}
						catch(StaleElementReferenceException e)
						{
							driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email")));
							textUsername = driver.findElement(By.id("email")); 
							textUsername.clear();  				
							Thread.sleep(2000);
					
							driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("passwd")));
							textPassword = driver.findElement(By.name("passwd")); 	// Finding element by name 
							textPassword.clear();  
					
						}	
					}
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	public void register()
	{
		
	}
}
