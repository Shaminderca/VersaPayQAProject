package com.versapay.qa.retryfailedtestlogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.versapay.qa.base.TestBase;



public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
//two things
	// max limit
	// counter
//this class will tell us , for how many time you want to run our failed test cases.
	int maxCount = 2;
	int counter = 0;

	@Override
	public boolean retry(ITestResult result) {

		while (counter != maxCount) {
			counter++;
			return true;
		}

		return false;
	}

}
