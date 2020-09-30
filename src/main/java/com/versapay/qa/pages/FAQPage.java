package com.versapay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versapay.qa.base.TestBase;

public class FAQPage extends TestBase {
	public FAQPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'PDF')]")
	WebElement pdfDownload;
	
	@FindBy(id="lp-pom-text-482")
	WebElement pdfZone;
	
	@FindBy(xpath="//div[@id='lp-pom-text-483']//em")
	WebElement backFaq;
	
	@FindBy(id="lp-pom-text-453")
	WebElement backFaqZone;
	
	@FindBy(id="//a[contains(text(),'How do I add Credit ')]")
	WebElement addCreditCard;
}
