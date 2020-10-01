package com.versapay.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.versapay.qa.base.TestBase;

public class TestDataUtil extends TestBase{


	public TestDataUtil(){
		PageFactory.initElements(driver, this);
	}	
	
	
	public Object [][] getTestdata(String sheetName) throws IOException{
		
		FileInputStream file=null;
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\versapay\\qa\\testdata\\VersaPayTestData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet(sheetName);
		
		int rowCount= sheet.getLastRowNum();
		int cellCount= sheet.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[rowCount][cellCount];
		for (int i=0;i<rowCount;i++) {
			for (int j=0; j<cellCount; j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
				}
			System.out.println(data);
			}
		return data;

	}
}
