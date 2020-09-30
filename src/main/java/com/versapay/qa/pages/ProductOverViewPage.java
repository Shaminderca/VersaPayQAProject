package com.versapay.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.versapay.qa.base.TestBase;

public class ProductOverViewPage extends TestBase {
	JavascriptExecutor jse ;
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public ProductOverViewPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='_1J2yFoCxhYCdrBtoRHq-lk']//p[contains(text(),'Book A Free Demo')]")
	WebElement bookFreeDemo;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "companyName")
	WebElement companyName;

	@FindBy(id = "phone")
	WebElement phone;
	
	@FindBy(xpath="//button//p[contains(text(),'Submit')]")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='cMmfqTv2K0TpU4uu1br8B']")
	WebElement seeYouSoon;
	
	public boolean bookFreeDemo() {
		
		bookFreeDemo.click();
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys("abcd");
		lastName.sendKeys("efgh");
		email.sendKeys("ijkl@gmail.com");
		companyName.sendKeys("mnop");
		phone.sendKeys("98784534");
		submitButton.click();
		return seeYouSoon.isDisplayed();
		
		
	}
}
