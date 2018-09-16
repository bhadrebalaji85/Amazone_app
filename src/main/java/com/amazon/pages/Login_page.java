package com.amazon.pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.SelendroidFindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.FileNotFoundException;
import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.testbase.TestBase;
public class Login_page extends TestBase

{
	   private static final int MAX_WEBSITE_LOAD_TIME = 20;
		@AndroidFindBy(id="sign_in_button")
		WebElement Already_customer_signin;
		
		@AndroidFindBy(id="ap_email_login")
		WebElement Enter_email;
		
		@AndroidFindBy(id="continue")
		WebElement continue_button;
		
		@AndroidFindBy(id="ap_password")
		WebElement Enter_password;
		
		@AndroidFindBy(id="signInSubmit")
		WebElement Sign_button;
		
		@AndroidFindBy(xpath="//*[contains(@resource-id,'action_bar_burger_icon')]")
		WebElement humburger_setting;
		
		@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desk,'Navigation panel')]")
		WebElement humburger_setting1;
		
		public Login_page() throws FileNotFoundException 
			{
			PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			}

		public String Validate_titile()
			{
				return driver.getTitle();
			}
	
		public void Already_customer_signin_test() throws InterruptedException
			{

					isElementPresent(Already_customer_signin,10);
					Already_customer_signin.click();
					isElementPresent(Enter_email,20);
					Enter_email.sendKeys("bhadrebalaji@gmail.com");
					continue_button.click();
					isElementPresent(Enter_password,20);
					Boolean flag=Enter_password.isDisplayed();
					System.out.println("Password field is:"+flag);
					Enter_password.sendKeys("jodha@123");
					isElementPresent(Sign_button,10);
					Sign_button.click();
					isElementPresent(humburger_setting,20);
					//humburger_setting.click();

			}
}

