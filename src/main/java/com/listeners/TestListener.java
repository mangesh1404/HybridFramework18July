package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.TestBase;

public class TestListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		TestBase.log.info("test cazse started with execution "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		TestBase.log.info("test cazse passed with execution "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		TestBase.log.info("test cazse failed with execution "+result.getName());
		TestBase.getScreenshot(TestBase.driver, result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		TestBase.log.info("test cazse skipped with execution "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		TestBase.log.info("suite is ready to start the execution");
	}

	public void onFinish(ITestContext context) {
		TestBase.log.info("suite is finished successfully");
	}

}
