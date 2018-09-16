package com.amazon.qa.setup;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest {
	
	public AndroidDriver driver;
  @Test
  public void f() {
	  
	  try{
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setCapability("deviceName", "Virual Device");
          capabilities.setCapability("browserName", "Android");
          capabilities.setCapability("platformVersion", "7.1.1");
          capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping"); 
          capabilities.setCapability("appActivity","com.amazon.mShop.sso.SigninPromptActivity");
          driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
          if(driver.isAppInstalled("in.amazon.mShop.android.shopping") == true)
          {
              System.out.println("App already present");

          }
          else
          {
          capabilities.setCapability("app", "C://Users//HP//Amazon_India_Online_Shopping_v16.11.0.300_apkpure.com.apk");
          }
          
          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
          System.out.println("TC0 :-App Launched Successfully");
          } catch(Throwable e)
            {
                System.out.println("Test Case Failed");

            }
         }
  }

