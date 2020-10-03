package com.versapay.qa.retryfailedtestlogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.versapay.qa.base.TestBase;

//This class keeps the count of the times for which a test is retired before marking it as failed.

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
//two things
	// max limit
	// counter
//this class will tell us , for how many time you want to run our failed test cases.
	int maxCount = 2;
	int counter = 0;

	@Override
	public boolean retry(ITestResult result) {
		
		System.out.println("Inside Retry logic");

		while (counter != maxCount) {
			counter++;
			return true;
		}

		return false;
	}

}
