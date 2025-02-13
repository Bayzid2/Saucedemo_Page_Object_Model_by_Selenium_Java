package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(className = "inventory_item_name")
    List<WebElement> cartItems;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartBadge;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOut;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   public void proceedToCheckout() {
	   checkOut.click();
   }
    public boolean verifyItemsInCart(int expectedCount) {
        return cartItems.size() == expectedCount;
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(cartBadge.getText());
    }
}

