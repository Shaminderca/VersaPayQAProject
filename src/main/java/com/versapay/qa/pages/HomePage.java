package com.versapay.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.versapay.qa.base.TestBase;


public class HomePage extends TestBase {
	
	JavascriptExecutor jse;
	WebDriverWait wait;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
    
	
	@FindBy(id="email")
	WebElement emailfield;
	
	@FindBy(xpath="//button//p[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath="//div//a//p[contains(text(),'AR is Changing')]")
	WebElement arIsChanging;
	
	@FindBy(xpath="//div//a//p[contains(text(),'Solutions')]")
	WebElement solutions;
	
	@FindBy(xpath="//div[@class='EVKxlXd5eayuI3ObLJVgO']//p[contains(text(),'Product')]")
	WebElement product;
	
	@FindBy(xpath="//div//a//p[contains(text(),'Resources')]")
	WebElement resources;
	
	@FindBy(xpath="//div//p[contains(text(),'More')]")
	WebElement more;
	
	@FindBy(xpath="//div//p[contains(text(),'FAQ')]")
	WebElement faq;
	
	@FindBy(xpath="//button[@title='Dismiss']//img")
	WebElement popUpClose;
	
	@FindBy(xpath="//p[@class='GV8lFp4fPNdVHwOXCBXsN']")
	WebElement signedUpMessage;
	
	@FindBy(xpath="//div[@class='_27IxuZYr8u3tVpHTWchWiZ'][1]//p[contains(text(),'Overview')]")
	WebElement overview;
	
	
	public boolean signUp() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",emailfield);
		emailfield.sendKeys("abcdef@gmail.com");
		signUpButton.click();
	    return signedUpMessage.isDisplayed();
		
	}
	
	public String emptySignUp() {
		signUpButton.click();
		Actions a = new Actions(driver);
		a.moveToElement(emailfield).build().perform();
		String rgbaValue = emailfield.getCssValue("background-color");
		String color = Color.fromString(rgbaValue).asHex();
		return color;
		
	}
	
	public ArIsChangingPage navigateToArIsChangingPage() {
		arIsChanging.click();
		return new ArIsChangingPage();
		
	}
	
	public ProductOverViewPage navigateToProductOverViewPage() {
		Actions a = new Actions(driver);
		a.moveToElement(product).build().perform();
		a.moveToElement(overview).build().perform();
		overview.click();
		return new ProductOverViewPage();
		
		
	}
	
	public FAQPage naviagateToFAQPage() {
		Actions a = new Actions(driver);
		a.moveToElement(more).build().perform();
		a.moveToElement(faq).build().perform();
		faq.click();
		return new FAQPage();
		
	}
	
}
