package com.website.homepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.website.LoginPage.LoginPage;

public class HomePage extends LoginPage
{

	protected WebElement txtboxSearch;
	protected WebElement dropdwnSort;
	protected WebElement testproduct;
	
	 public void getproduct()
	 {
		 txtboxSearch = driver.findElement(By.id("search_query_top"));
		 txtboxSearch.sendKeys("dresses");
		 txtboxSearch.submit();
		 
		 dropdwnSort = driver.findElement(By.id("selectProductSort"));
		 Select selectsortby = new Select(dropdwnSort);
		 selectsortby.selectByIndex(1);
			
		 testproduct =  driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));	
		 testproduct.click();	   
	 }	
}
