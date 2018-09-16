package com.amazon.qa.testbase;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.config.Constant;

	public class TestBase
		{
			public static AndroidDriver driver;
		    //public AndroidDriver<WebElement> driver;
			public static Properties prop;
			public static File file;
			public static File apk_file;
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Constructor $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */			
			public TestBase() throws FileNotFoundException
			{
				file=new File(Constant.config_path);
				FileInputStream fileInput = null;
				try {
					fileInput = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			   prop = new Properties();
				
				//load properties file
				try {
					prop.load(fileInput);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ End $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
			
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ FUNCTION DesiredCapabilities $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
  	public AndroidDriver Android_DesiredCapabilities() throws MalformedURLException 
  				{
                  try{
  						DesiredCapabilities capabilities = new DesiredCapabilities();
  						/*capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
  						System.out.println("Device Name:"+prop.getProperty("DEVICE_NAME"));
  						capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("Platform"));
  						System.out.println("Platform:"+prop.getProperty("Platform"));
  						capabilities.setCapability(MobileCapabilityType.VERSION, prop.getProperty("platformVersion"));
  						System.out.println("Platform_Version:"+prop.getProperty("platformVersion"));
  						capabilities.setCapability("appPackage",prop.getProperty("appPackage")); 
  						capabilities.setCapability("appActivity",prop.getProperty("appActivity"));
  						capabilities.setCapability("newCommandTimeout", "45000");*/
  						driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
  						boolean b=driver.isAppInstalled("in.amazon.mShop.android.shopping");
  						System.out.println("Current App Status:"+b);
  						if(driver.isAppInstalled("in.amazon.mShop.android.shopping") == true)
  							{
							System.out.println("App already present");
  						}
				else
					{
					capabilities.setCapability("app", "C://Users//HP//Amazon_India_Online_Shopping_v16.11.0.300_apkpure.com.apk");
					}
				        //driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
						//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						System.out.println("TC0 :-App Launched Successfully");
						
				       
				} catch(Throwable e)
					{
						System.out.println("Test Case Failed");

					}
                  return driver;
}
  	/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ End $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
  	
  		public boolean isElementPresent(WebElement elementName, int timeout){
  			try{
  					WebDriverWait wait = new WebDriverWait(driver, timeout);
  					wait.until(ExpectedConditions.visibilityOf(elementName));
  					return true;
  				}catch(Exception e){
  					System.out.println("Element not found"+elementName);
  					return false;
        }
    }
  		
}


