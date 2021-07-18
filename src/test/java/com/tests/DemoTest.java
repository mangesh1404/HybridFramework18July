package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

	// text, contains, following, preceding, following-sibling,preceding-sibling
	// parent child, ancestor, descendant,
	/*
	 * Uing   OR , AND

 	a. AND------ it will be true when both conditions are true

// tagName[@atrr1/fun1='value1'       and  @atrr2/function2='value2' ]

// input   [@class=    'form-control' and  @id=              'email' ]
	 * 
	 * 
	 */
	
	WebDriver driver;
	
	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	
	}
	
	@Test
	public void test02() {
		
		// types of xpath
		// absolute and relative
		//absolute--- always starts with /
		// relative xpath always starts with //
		
		
		// standard syntax of xpath
		// tagname[@ attr.name='value']	
		//  input [@ id       ='email']
		
		//xpath axes--- some modification in std. xapth to locate an unique element
		
	}
	// input[contains(@id,'ema')]
	// input[starts-with(@id,'ema')]
	// input[ends-with(@id,'ail')]
	
}
