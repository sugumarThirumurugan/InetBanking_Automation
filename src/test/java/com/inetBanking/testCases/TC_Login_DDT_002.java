package com.inetBanking.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtilities;

public class TC_Login_DDT_002 extends BaseClass{
	
	@DataProvider(name="ExcelData")
	public String[][] dataProvider() throws Exception{
		XLUtilities xlUtility = new XLUtilities("E:\\eclipse workspace_new\\inetBankingV1\\testData\\loginTestData.xlsx");
		int row = xlUtility.getRow("sheet1");
		int cell = xlUtility.getCell("sheet1");
		String data[][] = new String[row][cell];
		for(int i=1; i<=row; i++) {
			for(int j=0; j<cell; j++) {
				data[i-1][j]=xlUtility.getData(i, j, "sheet1");	
			}}
		return data;
	}
	
	@Test(dataProvider = "ExcelData")
	public void login(String data[]) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(data[0]);
		loginPage.setPassword(data[1]);
		loginPage.clickLoginButton();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			logger.warn("LoginFailed");
		}
		else {
			logger.info("LoginSucessfully Done");
			loginPage.clickLogout();
			driver.switchTo().alert().accept();
			
		}
	}
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	

}












