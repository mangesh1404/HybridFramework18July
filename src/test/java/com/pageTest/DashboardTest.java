package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.UserPage;

public class DashboardTest extends TestBase{

	DashboardPage dp=null;
	static UserPage up=null;
	@Test
	public void verifyCourses() {
		dp=LoginTest.dp;
		Assert.assertTrue(dp.verifyAllCourses());
	}
	
	@Test
	public void verifyUserPage() {
		test = extent.createTest("verifyUserPage");
		up=dp.clickUsers();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	}

}