package com.amazon.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.testbase.TestBase;

public class Skip_Sign_in extends TestBase {
	
	
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/skip_sign_in_button")
	WebElement Skip_signin_button;
	
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/rs_search_src_text")
	WebElement Search_product;
	
	public Skip_Sign_in() throws FileNotFoundException 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	public void skip_sign_in() throws InterruptedException
	{
		
		Skip_signin_button.click();
		//isElementPresent(Search_product,20);
		//Search_product.sendKeys("iphone");
	}
}
