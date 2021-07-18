package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	static FileInputStream fis=null;
	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	public static String readProperty(String key) {
		log.info("reading a value for a property: "+key);
		Properties prop = new Properties();
		try {
			log.info("initializing property file");
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			log.error("invalid property file path");
			e.printStackTrace();
		}
		log.info("proerty value found in the file with key as: "+key+" and value is: "+prop.getProperty(key));
		return prop.getProperty(key);
	}
	
	public static WebDriver initialization() {
		log.info("initializing browser");
		if(readProperty("browser").equalsIgnoreCase("chrome")) {
			log.info("user wants to automate with chrome browser");
			System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(readProperty("browser").equalsIgnoreCase("firefox")) {
			log.info("user wants to automate with firefox browser");
			System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else {
			log.info("user wants to automate with invalid browser");
			System.out.println("invalid browser name");
			return null;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("launching an application");
		driver.get(readProperty("url"));
		return driver;
		}
	
	public static void getScreenshot(WebDriver driver,String name) {
		log.info("test case failed and taking screenshot");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/screenshots/"+name+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("screenshot saved in the project directory");
	}
	
	public static void main(String[] args) {
		System.out.println(readProperty("browser"));
		driver=initialization();
		getScreenshot(driver, "demo");
		
	}
	
}
