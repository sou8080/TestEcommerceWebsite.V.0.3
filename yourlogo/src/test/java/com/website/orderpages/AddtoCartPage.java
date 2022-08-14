package com.website.orderpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.website.homepages.HomePage;

public class AddtoCartPage extends HomePage
{
	protected WebElement addtobtn;
	protected WebElement testQty;
	protected WebElement testSize;
	protected WebElement continueshop;
	protected WebElement txtboxSearch1;
	protected WebElement addtobtn2;
	protected WebElement proceedtocheckout;
	
	public void addtocart() throws InterruptedException
	{
		driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("icon-plus")));
		testQty = driver.findElement(By.className("icon-plus"));
		testQty.click();
		
		Thread.sleep(2000);
		testSize = driver.findElement(By.id("group_1"));
		Select selectSize = new Select(testSize);
		selectSize.selectByIndex(2);
		
		addtobtn = driver.findElement(By.name("Submit")); // adding items to cart
		addtobtn.click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		continueshop = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", continueshop);
		
		txtboxSearch1 = driver.findElement(By.id("search_query_top"));
		txtboxSearch1.sendKeys("dresses");
		txtboxSearch1.submit();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		addtobtn2 = driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span"));
		js.executeScript("arguments[0].click();", addtobtn2);
		
		proceedtocheckout = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span"));
		js.executeScript("arguments[0].click();", proceedtocheckout);
		
	}
}
