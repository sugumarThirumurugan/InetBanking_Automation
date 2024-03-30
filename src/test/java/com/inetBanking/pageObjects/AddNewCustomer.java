package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")  WebElement newCustomer;
	@FindBy(how=How.NAME,using="name")  WebElement customerName;
	@FindBy(how=How.XPATH,using="//input[@value='f']") WebElement gender;
	@FindBy(how=How.ID,using="dob")  WebElement dob;
	@FindBy(how=How.NAME,using="addr") WebElement address;
	@FindBy(how=How.NAME,using="city")  WebElement city;
	@FindBy(how=How.NAME,using="state")  WebElement state;
	@FindBy(how=How.NAME,using="pinno")  WebElement pincode;
	@FindBy(how=How.XPATH,using="//input[@name='telephoneno']") WebElement mobileNumber;
	@FindBy(how=How.XPATH,using="//input[@name='emailid']") WebElement email;
	@FindBy(how=How.XPATH,using="//input[@name='password']") WebElement password;
	@FindBy(how=How.NAME,using="sub") WebElement submit;
	
	public AddNewCustomer(WebDriver driver) { //Constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickNewCustomer() {
		newCustomer.click();
	}
	public void setCustomerName(String name) {
		customerName.sendKeys(name);
	}
	public void setGender() {
		gender.click();
	}
	public void setDOB(String dobData[]) {
		dob.sendKeys(dobData[0]);
		dob.sendKeys(dobData[1]);
		dob.sendKeys(dobData[2]);
	}
	public void setAddress(String address) {
		this.address.sendKeys(address);
	}
	public void setCity(String city) {
		this.city.sendKeys(city);
	}
	public void setState(String state) {
		this.state.sendKeys(state);
	}
	public void setPincode(String pincode) {
		this.pincode.sendKeys(pincode);
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber.sendKeys(mobileNumber);
	}
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickSubmit() {
		submit.click();
	}
	

}









