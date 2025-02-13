package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseDriver {
	
	public WebDriver driver;
	protected static String url = "https://www.saucedemo.com/";
	@BeforeSuite
public void startBrowser() {
		
	String browser_name =System.getProperty("browser", "chrome");
	
	if(browser_name.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	else if(browser_name.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	else if(browser_name.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	else if(browser_name.equals("safari")) {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
		driver.manage().window().maximize();
	}
	else {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	pageDriver.getInstance().setDriver(driver);
}
	@AfterSuite
	public void closeBrower() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		
	}
}
