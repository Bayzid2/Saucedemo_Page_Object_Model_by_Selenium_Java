package com.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.CommonMethods;

public class SortingTest extends CommonMethods {

	@BeforeTest
	public void openUrl() {
		driver.get("https://www.saucedemo.com/");
	}
	    @Test
	    public void testSortingByZtoA() throws InterruptedException {
	    	LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        timeout();
	        ProductPage productPage = new ProductPage(driver);
	        timeout();
	        productPage.selectZtoA();
	        
	        String TextOfSort = productPage.textZtoA();
	        Assert.assertTrue(TextOfSort.contains("Name (Z to A)"), "Error.");
	    }
	    
//	    @Test(priority = 1)
	    public void testSortingBylowToHigh() throws InterruptedException {
	    	LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        timeout();
	        ProductPage productPage = new ProductPage(driver);
	        productPage.lowToHigh();
	        
	        String TextOfSort = productPage.texthighToLow();
	        Assert.assertTrue(TextOfSort.contains("Price (low to high)"), "Error.");
	    }
	    
//	    @Test(priority = 2)
	    public void testSortingByHighToLow() throws InterruptedException {
	    	LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        timeout();
	        ProductPage productPage = new ProductPage(driver);
	        productPage.highToLow();
	        
	        String TextOfSort = productPage.texthighToLow();
	        Assert.assertTrue(TextOfSort.contains("Price (high to low)"), "Error.");
	    }
	}
	

