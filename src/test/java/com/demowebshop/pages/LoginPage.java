package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

//@Listeners (com.demowebshop.listeners.ListenerClass.class)
public class LoginPage {
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailId;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	
	public void loginUser(String email,String pass) throws InterruptedException {
		emailId.clear();
		emailId.sendKeys(email);
		password.clear();
		password.sendKeys(pass);
		loginButton.click();
	}
}
