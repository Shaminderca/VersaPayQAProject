package com.versapay.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.versapay.qa.base.TestBase;
import com.versapay.qa.pages.HomePage;
import com.versapay.qa.pages.ProductOverViewPage;
import com.versapay.qa.utils.TestDataUtil;

public class ProductOverviewPageTest extends TestBase {
	HomePage hp;
	ProductOverViewPage pp;
	TestDataUtil td;
	
	@BeforeMethod
	void startUp() {
		initialisation();
		hp = new HomePage();
		pp = hp.navigateToProductOverViewPage();
		td= new TestDataUtil();
	}
	
	@Test (dataProvider="getDemoData")
	public void bookFreeDemoTest(String fName,String lName,String email, String company, String phone)
	{
		boolean flag = pp.bookFreeDemo(fName,lName,email,company,phone);
		Assert.assertTrue(flag);
		
	}
	
	@DataProvider
	public Object[][] getDemoData() throws IOException{
		Object[][] data=td.getTestdata("demoData");	
		return data;
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
