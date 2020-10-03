package com.versapay.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versapay.qa.base.TestBase;

public class FAQPage extends TestBase {
	JavascriptExecutor jse;
	
	public FAQPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'How do I download a PDF of my invoice(s)?')]")
	WebElement pdfDownload;
	
	@FindBy(xpath="//strong[contains(text(),'How do I download a PDF of my invoice(s)?')]")
	WebElement lbl_pdfDownload;
	
	@FindBy(id="lp-pom-text-482")
	WebElement pdfZone;
	
	@FindBy(xpath="//div[@id='lp-pom-text-483']//em")
	WebElement backToFaqListing;
	
	@FindBy(id="lp-pom-text-453")
	WebElement FaqHeader;
	
	@FindBy(xpath="//a[contains(text(),'How do I add Credit Cards?')]")
	WebElement addCreditCard;
	
	@FindBy(xpath="//body/div[@id='lp-pom-root']/div[2]/div[37]/p[1]/span[1]/strong[1]")
	WebElement lbl_addCreditCard;
	
	
	public WebElement click_pdfDownloadLink() {
		pdfDownload.click();
		return lbl_pdfDownload;
	}
	public WebElement lbl_pdfDownload() {
		return lbl_pdfDownload;
	}
	public WebElement click_backToFaqListing() {
		backToFaqListing.click();
		return FaqHeader;
	}
	public WebElement FaqHeader() {
		return FaqHeader;
	}
	public WebElement click_addCreditCard() {
		addCreditCard.click();
		return lbl_addCreditCard;
	}
	public WebElement lbl_addCreditCard() {
		return lbl_addCreditCard;
	}
	public WebElement zone_pdfDownload() {
		return pdfZone;
	}
	

	
}
