package com.versapay.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.versapay.qa.base.TestBase;
import com.versapay.qa.pages.ArIsChangingPage;
import com.versapay.qa.pages.HomePage;

public class ArIsChangingPageTest extends TestBase {
	HomePage hp;
	ArIsChangingPage ar;
	
	@BeforeMethod
	void startUp()
	{
		initialisation();
		hp = new HomePage();
		ar = hp.navigateToArIsChangingPage();
	}
	
	@Test(priority=1)
	void imageDisplayTest()
	{
		boolean flag = ar.imageDisplay();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	void nameDisplayTest()
	{
		boolean flag = ar.nameDisplay();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	void tearDown()
	{
		driver.quit();
	}

}
