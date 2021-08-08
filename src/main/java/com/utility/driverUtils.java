package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class driverUtils extends TestBase{

	
	public static void waitForElement(WebElement element, long time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void main(String[] args) {
		waitForElement(driver.findElement(By.id("email")), 30);
	}
}
