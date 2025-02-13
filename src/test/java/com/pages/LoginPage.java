package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    
    @FindBy(id = "user-name")
    WebElement username;
    
    @FindBy(id = "password")
    WebElement password;
    
    @FindBy(id = "login-button")
    WebElement loginBtn;
    
    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsPage;
    
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    WebElement lockedError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public boolean isProductsPageDisplayed() {
        return productsPage.isDisplayed();
    }

	public String getErrorMessage() {
		return lockedError.getText();
	}
}
