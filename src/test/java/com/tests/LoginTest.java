package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utilities.CommonMethods;

public class LoginTest extends CommonMethods{
	
	@BeforeTest
	public void openUrl() {
		driver.get("https://www.saucedemo.com/");
	}

	    @Test
	    public void testValidLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        Assert.assertTrue(loginPage.isProductsPageDisplayed(), "Failed to log in with valid credentials.");
	    }

	    @Test(priority = 1)
	    public void testInvalidLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("wrong_user", "secret_sauce");
	        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container")).isDisplayed(), "Error message not shown for invalid login.");
	    }
	}


