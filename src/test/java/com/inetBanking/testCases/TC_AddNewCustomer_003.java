package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	@Test
	public void testNewCustomer() throws Exception{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickLoginButton();
		Thread.sleep(3000);
		AddNewCustomer newCustomer = new AddNewCustomer(driver);
		newCustomer.clickNewCustomer();
		newCustomer.setCustomerName("John");
		newCustomer.setGender();
		String dob[]= {"15","05","1998"};
		newCustomer.setDOB(dob);
		Thread.sleep(2000);
		newCustomer.setAddress("Chennai");
		newCustomer.setCity("Chennai");
		newCustomer.setState("TamilNadu");
		newCustomer.setPincode("605501");
		newCustomer.setMobileNumber("9858986847");
		newCustomer.setEmail(fakerClass());
		newCustomer.setPassword("Suriya@965525");
		newCustomer.clickSubmit();
		
		boolean contains = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(contains==true) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else {
			logger.info("Test Case Failed");
			captureScreen("AddNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
}







