package com.versapay.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versapay.qa.base.TestBase;

public class ArIsChangingPage extends TestBase {
	JavascriptExecutor jse;
	  
	public ArIsChangingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='_3SGqQQy9oECimd4lhn_kRy']")
	WebElement image;
	
	@FindBy(xpath="//p[@class='sQwmdWMrDIZVBLx33wm4g']")
	WebElement name;

	
	public boolean imageDisplay() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",image);
		return image.isDisplayed();
	
		
	}
	
	public boolean nameDisplay() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",name);
		return name.isDisplayed();
		
	}
}

