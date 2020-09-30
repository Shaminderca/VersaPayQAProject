package com.versapay.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.versapay.qa.base.TestBase;
import com.versapay.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage hp;

	@BeforeMethod
	void startUp() {
		initialisation();
		hp = new HomePage();
		
	}

	@Test(priority = 1)
	void signUpTest() {
		boolean flag = hp.signUp();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	void emptySignUpTest() {
		String flag =hp.emptySignUp();
		Assert.assertEquals(flag, prop.getProperty("color"));
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}
