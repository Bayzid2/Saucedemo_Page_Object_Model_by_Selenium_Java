package com.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.CommonMethods;

public class LogOutTest extends CommonMethods{

	@BeforeTest
	public void openUrl() {
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void logout() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        timeout();
        
        ProductPage productPage = new ProductPage(driver);
        productPage.dropDown();
        timeout(1000);
        productPage.logoutClick();
	}
	
}
