package com.versapay.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.versapay.qa.base.TestBase;
import com.versapay.qa.pages.HomePage;
import com.versapay.qa.pages.ProductOverViewPage;
import com.versapay.qa.utils.ExcelUtility;

public class ProductOverviewPageTest extends TestBase {
	HomePage hp;
	ProductOverViewPage pp;

	@BeforeMethod
	void startUp() {
		initialisation();
		hp = new HomePage();
		pp = hp.navigateToProductOverViewPage();

	}
	
	@Test
	void bookFreeDemoTest()
	{
		boolean flag = pp.bookFreeDemo();
		Assert.assertTrue(flag);
		
	}

	/*
	@Test(dataProvider = "TestDataProviderFromExcel")
	void bookFreeDemoTest(String fName, String lName, String eMail, String cName, String pNumber) {
		boolean flag = pp.bookFreeDemo(fName, lName, eMail, cName, pNumber);
		Assert.assertTrue(flag);
	}

	@DataProvider(name = "TestDataProviderFromExcel")
	String[][] TestDataProvider() {
		String filePath = "./TestData\\TestData.xlsx";
		int row = ExcelUtility.getRowCount(filePath, "Sheet1");
		int col = ExcelUtility.getCellCount(filePath, "Sheet1", 1);
		System.out.println("row " + row + "col " + col);
		String[][] SignUpTestData = new String[row][col];
		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				SignUpTestData[i - 1][j] = ExcelUtility.getCellData(filePath, "Sheet1", i, j);

			}

		}
		return SignUpTestData;
	}
	*/  

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
