package com.demowebshop.listeners;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.demowebshop.tests.TestLoginPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ListenerClass implements ITestListener{
	
	 static int count =0;
	
	 @Override
	 public void onFinish(ITestContext arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onStart(ITestContext arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestFailure(ITestResult arg0) {
		 count++;
		 TakesScreenshot ts = (TakesScreenshot)TestLoginPage.driver;
		  
		  File srcFile = ts.getScreenshotAs(OutputType.FILE);
		  
		  try {
		   FileUtils.copyFile(srcFile, new File("./ScreenShots/"+arg0.getName()+count+".jpg"));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
	  

	 @Override
	 public void onTestSkipped(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestStart(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestSuccess(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }
}
