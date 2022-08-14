package com.website.mainpage;

import java.io.IOException;

import com.website.orderpages.PlaceOrderPage;

public class MyWeb {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		PlaceOrderPage website = new PlaceOrderPage();
		website.indexPageSignUp();
		website.takescreenshot("signup");
		
		website.login();
		website.takescreenshot("login");
		website.getproduct();
		website.addtocart();
		website.takescreenshot("cart");
		
		website.placeorderpage();
		website.takescreenshot("orderpage");
		website.addresspage();
		website.shippingpage();
		website.paymentpage();
		website.takescreenshot("payment");
		website.confirmorderpage();
		website.takescreenshot("confirmpage");
		
		website.close();
	}

}
