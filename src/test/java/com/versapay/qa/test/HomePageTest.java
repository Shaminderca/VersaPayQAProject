package com.versapay.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.versapay.qa.base.TestBase;
import com.versapay.qa.pages.HomePage;

import com.versapay.qa.utils.TestDataUtil;

public class HomePageTest extends TestBase {
	HomePage hp;
	TestDataUtil td;

	@BeforeMethod
	void startUp() {
		initialisation();
		hp = new HomePage();
		td= new TestDataUtil();
		
	}

	@Test(dataProvider="getSignUpData")
	 public void signUpTest(String Email) {
		boolean flag=hp.signUp(Email);
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getSignUpData() throws IOException{
		Object[][] data=td.getTestdata("signUpData");	
		return data;
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
