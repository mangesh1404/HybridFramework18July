package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver  driver=null;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[text()='Users']")
	private WebElement usersBtn;
	
	@FindBy(xpath="//span[text()='Operators']")
	private WebElement operatorBtn;
	
	@FindBy(xpath="//span[text()='Downloads']")
	private WebElement downloadBtn;
	
	@FindBy(tagName="h3")
	private List<WebElement> courses;
	
	
	public boolean verifyAllCourses(){
		ArrayList<String> courseNames = new ArrayList<String>();
		for(WebElement course : courses) {
			String text= course.getText();
			courseNames.add(text);
		}	
		ArrayList<String> expCourses = new ArrayList<String>();
		expCourses.add("Selenium");
		expCourses.add("Java / J2EE");
		expCourses.add("Python");
		expCourses.add("Php");
		
		if(courseNames.equals(expCourses))
			return true;
		
		return false;
	}
	public UserPage clickUsers() {
		usersBtn.click();
		return new UserPage(driver);
	}
}
