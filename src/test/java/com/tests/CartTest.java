package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.CommonMethods;

public class CartTest extends CommonMethods {

	@BeforeTest
	public void openUrl() {
		driver.get("https://www.saucedemo.com/");
	}
        

	    @Test
	    public void testAddToCart() throws InterruptedException {
	    	
	    	LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        timeout();
	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);

	        productPage.addFirstTwoItemsToCart();
	        timeout();
	        productPage.openCart();

	        Assert.assertTrue(cartPage.verifyItemsInCart(2), "Items were not added to cart.");
	    }

	    @Test(priority = 1)
	    public void testCartBadgeUpdate() {
	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);

	        productPage.addFirstTwoItemsToCart();
	        Assert.assertEquals(cartPage.getCartBadgeCount(), 2, "Cart badge count is incorrect.");
	    }
	}


