package com.versapay.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.versapay.qa.base.TestBase;

public class Test extends TestBase {
	
	@BeforeMethod
	void startUp() {
		initialisation();
	}
	
	@org.testng.annotations.Test
	void MethodOne()
	{
	Assert.assertEquals(false, true);
	}
	
	
	@org.testng.annotations.Test
	void MethodTwo() {
		Assert.assertEquals(true, true);
	}
	
	@org.testng.annotations.Test
	void MethodThree()
	{
		String title =driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("VersaPa | Automated Accounts Receivable Software", title);
	}
	
	@BeforeMethod
	void tearDown() {
		driver.quit();
	}

}
