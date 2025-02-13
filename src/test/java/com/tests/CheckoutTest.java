package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.CheckoutPage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.CommonMethods;

public class CheckoutTest extends CommonMethods{
	
	@BeforeTest
	public void openUrl() {
		driver.get("https://www.saucedemo.com/");
	}
	
	 @Test
	    public void testCheckoutProcess() throws InterruptedException {
		  LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        timeout();
			ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);
	        CheckoutPage checkoutPage = new CheckoutPage(driver);

	        productPage.addFirstTwoItemsToCart();
	        timeout();
	        productPage.openCart();
	        timeout();
	        cartPage.proceedToCheckout();
	        timeout();
	        checkoutPage.enterCheckoutInfo("John", "Doe", "12345");
	        timeout();
	        checkoutPage.finishOrder();
	        timeout();
	        Assert.assertTrue(checkoutPage.verifyOrderSuccess(), "Order success message not found.");
	    }
}
