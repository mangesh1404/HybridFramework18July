package com.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest1 {
	WebDriver driver;
	
	public WebDriver launchDashboard() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		return driver;
	}
	
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
	driver=	launchDashboard();
	driver.findElement(By.xpath("//span[text()='Users']")).click();
	ArrayList<String> actData= new ArrayList<String>();
	List<WebElement> genders = driver.findElements(By.xpath("//td[6]"));
	for(WebElement gender : genders) {
		int row = genders.indexOf(gender)+2;//2, 3, 4, 5
		if(gender.getText().equals("Male")) 
			actData.add(driver.findElement(By.xpath("//tr["+row+"]/td[2]")).getText());
	}
	
	}
	
	
	
}
