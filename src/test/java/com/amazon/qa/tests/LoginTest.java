package com.amazon.qa.tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.pages.Login_page;
import com.amazon.pages.Skip_Sign_in;
import com.amazon.qa.setup.Appium_Server_Status;
import com.amazon.qa.testbase.TestBase;

public class LoginTest extends TestBase {

	public Login_page loginpage;
	public Skip_Sign_in skip_signin;
	public LoginTest() throws FileNotFoundException {
		
		super();
		// TODO Auto-generated constructor stub
		
	}

	@BeforeTest
	public void setupTest() throws MalformedURLException, FileNotFoundException
	{
		Appium_Server_Status.checkIfServerIsRunnning(4723);
		Android_DesiredCapabilities();
		loginpage=new Login_page();
		skip_signin=new Skip_Sign_in();
	}
  
	@Test
  public void Loginto_AmazoneTest() throws MalformedURLException, FileNotFoundException, InterruptedException 
			{
		 		loginpage.Already_customer_signin_test();
			}
	
	
	//@Test(enabled=false)
	  //public void Skip_sign_test() throws MalformedURLException, FileNotFoundException, InterruptedException 
			//{
				//skip_signin.skip_sign_in();
			//}
  
	
	@AfterMethod
	public void close_AppTest()
	 {
		//driver.closeApp();
	 }
}
