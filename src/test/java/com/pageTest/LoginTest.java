package com.pageTest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginTest {
	WebDriver driver=null;
	LoginPage lp=null;
	DashboardPage dp=null;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();//test
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		lp = new LoginPage(driver);	
	}
	@Test
	public void logintest() {
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test
	public void verifyCourses() {
		
		
		Assert.assertTrue(dp.verifyAllCourses());
	}
	
	
	
	
}
