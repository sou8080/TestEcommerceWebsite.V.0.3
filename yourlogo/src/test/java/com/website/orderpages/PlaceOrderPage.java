package com.website.orderpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaceOrderPage extends AddtoCartPage
{
	protected WebElement orderpagechkout;
	protected WebElement testTrashbtn;
	protected WebElement addresspagechkout;
	protected WebElement testcheckbox;
	protected WebElement shippingpagechkout;
	protected WebElement paymentpage;
	protected WebElement confirmOrderPage;
	
	
	public void placeorderpage()
	{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		testcheckbox = driver.findElement(By.cssSelector("#\\31 _5_0_720937 > i"));
		testcheckbox.click();
		
		orderpagechkout = driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span"));
		orderpagechkout.click();
	}
	
	public void addresspage() 
	{
		addresspagechkout = driver.findElement(By.cssSelector("#center_column > form > p > button > span"));
		addresspagechkout.click();
		
	}
	
	public void shippingpage()
	{
		testcheckbox = driver.findElement(By.cssSelector("#cgv"));	
		testcheckbox.click();
		
		shippingpagechkout = driver.findElement(By.cssSelector("#form > p > button > span"));
		shippingpagechkout.click();
	}
	
	public void paymentpage()
	{
		paymentpage = driver.findElement(By.partialLinkText("Pay by bank wire"));
		paymentpage.click();
	}
	
	public void confirmorderpage()
	{
		confirmOrderPage = driver.findElement(By.cssSelector("#cart_navigation > button > span"));	
		confirmOrderPage.click();
	}
}
