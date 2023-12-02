package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.base.TestBase;

public class HomePage extends TestBase{
	Actions a = new Actions(driver);
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginText;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void gettitle(){
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	public void clickonLogin(){
		loginText.click();
	}
	

}
