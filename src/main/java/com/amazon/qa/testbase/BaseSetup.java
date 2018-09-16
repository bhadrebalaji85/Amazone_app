package com.amazon.qa.testbase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.amazon.qa.setup.Appium_Server_Status;

public class BaseSetup {
	public WebDriver driver;
	//public AppiumDriver driver;
	@Test
  	public void initDriver() throws MalformedURLException 
		{
		Appium_Server_Status.checkIfServerIsRunnning(4723);
		//File apk_file_path= new File("C://Users//HP//Amazon_India_Online_Shopping_v16.11.0.300_apkpure.com.apk");
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Virual Device");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//cap.setCapability(MobileCapabilityType.APP,apk_file_path);
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping"); 
		cap.setCapability("appActivity","com.amazon.mShop.sso.SigninPromptActivity"); 
		
		driver =  new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		//AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		//driver =  new AppiumD(new URL("http://127.0.0.1:4723/wd/hub"), cap)
		 //driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		WebElement sign_in_button=driver.findElement(By.id("sign_in_button"));
		sign_in_button.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email_login")));
		driver.findElement(By.id("ap_email_login")).sendKeys("bhadrebalaji");
		
	
		}
}
