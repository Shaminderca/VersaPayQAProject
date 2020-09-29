package com.versapay.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.versapay.qa.base.TestBase;
import com.versapay.qa.pages.FAQPage;
import com.versapay.qa.pages.HomePage;

public class FAQPageTest extends TestBase{
	HomePage hp;
	FAQPage fqa;
	

	@BeforeMethod
	void starUp() {
		initialisation();
		hp = new HomePage();
		fqa = hp.naviagateToFAQPage();
	}
	
	@Test
	void TestNumberOne()
	{
		System.out.println("Hey There");
	}
}

