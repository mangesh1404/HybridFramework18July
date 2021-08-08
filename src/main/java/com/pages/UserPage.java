package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	WebDriver driver;
	
	@FindBy(tagName="th")
	List<WebElement> headers;
	
	public UserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAllHeaders(){
		ArrayList<String> actualHeaders = new ArrayList<String>();
		for(WebElement course : headers) {
			String text= course.getText();
			actualHeaders.add(text);
		}	
		ArrayList<String> expHeaders = new ArrayList<String>();
		expHeaders.add("#");
		expHeaders.add("Username");
		expHeaders.add("Email");
		expHeaders.add("Mobile");
		expHeaders.add("Course");
		expHeaders.add("Gender");
		expHeaders.add("State");
		expHeaders.add("Action");
		
		if(actualHeaders.equals(expHeaders))
			return true;
		
		return false;
	}
	
}
