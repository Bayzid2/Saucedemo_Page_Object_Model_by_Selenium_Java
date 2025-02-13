package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "complete-header")
    WebElement orderCompleteMsg;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCheckoutInfo(String first, String last, String zip) {
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        postalCode.sendKeys(zip);
        continueBtn.click();
    }

    public void finishOrder() {
        finishBtn.click();
    }

    public boolean verifyOrderSuccess() {
        return orderCompleteMsg.getText().contains("Thank you for your order!");
    }
}

