package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> addToCartButtons;
    
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement dropdown;
  
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement Logout;
    
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortClick;
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstTwoItemsToCart() {
        addToCartButtons.get(0).click();
        addToCartButtons.get(1).click();
    }

    public void openCart() {
        cartIcon.click();
    }
    
    public void dropDown() {
    	dropdown.click();
    }

    public void logoutClick() {
    	Logout.click();
    }
    
    public void selectZtoA() {
    	sortClick.click();
    	Select select = new Select(sortClick);
 	   select.selectByIndex(1);
    }
    
    public void lowToHigh() {
    	sortClick.click();
    	Select select = new Select(sortClick);
 	   select.selectByIndex(2);
    }
    
    public void highToLow() {
    	sortClick.click();
    	Select select = new Select(sortClick);
 	   select.selectByIndex(3);
    }

    public String textZtoA() {
		return sortClick.getText();
	}
    public String textlowToHigh() {
		return sortClick.getText();
	}
    public String texthighToLow() {
		return sortClick.getText();
	}
    

}

