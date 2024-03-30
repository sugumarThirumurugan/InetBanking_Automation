package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(name="uid") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement login;
	@FindBy(xpath="//ul[@class='menusubnav']//child::li[15]") WebElement logout; 
	
	public LoginPage(WebDriver driver) {  // Constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	public void setUserName(String userName) {
		this.userName.sendKeys(userName);
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickLoginButton() {
		login.click();
	}
	public void clickLogout() {
		logout.click();
	}

}
