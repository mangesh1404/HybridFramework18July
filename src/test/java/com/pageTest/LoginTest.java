package com.pageTest;



import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginTest extends TestBase {
	WebDriver driver=null;
	LoginPage lp=null;
	static DashboardPage dp=null;
	
	@BeforeSuite(groups="smoke")
	public void setup() {
		driver =initialization();
		lp = new LoginPage(driver);	
	}
	@Test(groups="smoke")
	public void logintest() {
		test = extent.createTest("logintest");
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	
	
	
	
	
}
