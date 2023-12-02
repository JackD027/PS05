package com.demowebshop.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.base.TestBase;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utilities.ExcelDataProvider;

public class TestLoginPage extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	static int row=0;
	ITestContext con;
	
	@BeforeMethod
	public void OpenApp(ITestContext context)
	{
		openBrowser(context);		
		homePage = new HomePage(driver);
		loginPage= new LoginPage(driver);
	}
	
	
	@AfterMethod
	public void CloseApp()
	{
		driver.quit();
	}
	
	@Test
	public void testLoginUser() throws InterruptedException{
		homePage.clickonLogin();
		loginPage.loginUser("admin123@google.com","admin123");
		String actualEmail= driver.findElement(By.xpath("(//a[@class='account'])[1]")).getText();
		System.out.println(actualEmail);
	}
	
	// @Test(dataProvider="testdata")
	// public void testLoginUserByExcel(String emailString,String passwordString,String statusString) throws Exception {
	// 	row+=1;
	// 	statusString="Failed";
	// 	homePage.clickonLogin();
	// 	loginPage.loginUser(emailString,passwordString);
	// 	String actualEmail= driver.findElement(By.xpath("(//a[@class='account'])[1]")).getText();
	// 	//System.out.println(actualEmail);
	// 	if(actualEmail.equals(emailString)) {
	// 		statusString="Passed";
	// 		System.out.println(statusString);
	// 		ExcelDataProvider.addTestData(row,statusString);
	// 	}
	// 	if(!actualEmail.equals(emailString)) {
	// 		ExcelDataProvider.addTestData(row,statusString);
	// 		System.out.println(statusString);
	// 		throw new Exception();
	// 	}
	// }
	
	// @DataProvider(name="testdata")
	// public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	// {
		
	// 	Object[] [] input = ExcelDataProvider.getTestData("Sheet1");
	// 	return input;
		
	// }
}
