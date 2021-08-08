package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.UserPage;

public class UserTest extends TestBase {

	UserPage up=null;
	
	@Test
	public void verifyUserHeaders() {
		test = extent.createTest("verifyUserHeaders");
		up=DashboardTest.up;
		Assert.assertTrue(up.verifyAllHeaders());
	}
	
}
