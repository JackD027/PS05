package com.demowebshop.base;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestBase {

	public static WebDriver driver;
	public static ExtentReports extentreports;
  	public static ExtentTest extentTest;
	
  
  	public static void openBrowser()
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
  	  	extentTest = extentreports.createTest(context.getName());

	}

     public void closebrowser() {
   	  driver.quit();
     }
     
     @BeforeSuite
     public void InitalizeExtentReport()
     {
 		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("report.html");
 		extentreports = new ExtentReports();
 		extentreports.attachReporter(sparkreporter);
 		
 		// on the report display more information about OS, java
 		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
 		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));
 	}

 	@AfterSuite
 	public void generateReports() throws IOException
 	{
 		extentreports.flush();
 		Desktop.getDesktop().browse(new File("report.html").toURI());
 	}
 	
 	@AfterMethod
	public void generateTestStatus(Method m,ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE )
		{
			System.out.println("Capture Screenshot");
			extentTest.fail(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
	}

	
}
