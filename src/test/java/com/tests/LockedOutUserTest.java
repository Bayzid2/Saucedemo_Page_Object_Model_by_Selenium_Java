package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utilities.CommonMethods;

public class LockedOutUserTest extends CommonMethods{

	@BeforeTest
	public void openUrl() {
		driver.get("https://www.saucedemo.com/");
	}
	 @Test
	    public void verifyLockedOutUserCannotLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("locked_out_user", "secret_sauce");

	        String errorMessage = loginPage.getErrorMessage();
	        Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out"), "Locked out user error message not displayed.");
	    }
}
