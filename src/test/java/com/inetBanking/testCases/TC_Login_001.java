package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{
	
	
	@Test()
	public void loginTest()throws Exception {
		logger.info("URL is Loaded");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("userName is Entered");
		loginPage.setPassword(password);
		logger.info("Password is Entered");
		loginPage.clickLoginButton();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {	
			captureScreen("loginTest");
			System.out.println("TestCase Failed");
		}
	}

}
