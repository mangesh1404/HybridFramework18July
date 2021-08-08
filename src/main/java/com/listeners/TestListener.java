package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.TestBase;

public class TestListener implements ITestListener{
	private Logger log = Logger.getLogger(TestListener.class);
	public void onTestStart(ITestResult result) {
		log.info("test cazse started with execution "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("test cazse passed with execution "+result.getName());
		TestBase.test.log(Status.PASS, "test Case passed is "+result.getName());
		//TestBase.extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		log.info("test cazse failed with execution "+result.getName());
		String path=TestBase.getScreenshot(TestBase.driver, result.getName());
		TestBase.test.log(Status.FAIL, "test Case Failed is "+result.getName());
		TestBase.test.log(Status.FAIL, "test Case Failed is "+result.getThrowable());			
		TestBase.test.log(Status.FAIL,"testcase failed");
		TestBase.test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
		log.info("test cazse skipped with execution "+result.getName());
		TestBase.test.log(Status.SKIP, "test Case Skipped is "+result.getName());
		//TestBase.extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		log.info("suite is ready to start the execution");
	}

	public void onFinish(ITestContext context) {
		TestBase.extent.flush();
		log.info("suite is finished successfully");
	}

}
