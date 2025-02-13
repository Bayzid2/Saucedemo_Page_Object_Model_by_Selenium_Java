package com.drivers;

import org.openqa.selenium.WebDriver;

public class pageDriver {

	public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal <WebDriver>();
	private static pageDriver instance = null;
	
	private pageDriver() {
		
	}
	
	public static pageDriver getInstance() {
		if(instance == null) {
			instance = new pageDriver();
		}
		
		return instance;
		 
	}
	public WebDriver getDriver() {
	  return webDriver.get();	 
	}
	public void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}
	public static WebDriver getCurrentDriver() {
		return getInstance().getDriver();
	}
	
} 
