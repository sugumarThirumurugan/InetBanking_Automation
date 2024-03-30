package com.inetBanking.testCases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	public String url=readConfig.getUrl();
	public String userName=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public TakesScreenshot screenShot;
	public Faker faker;
	
	@Parameters("browser")
	@BeforeClass()
	public void setUp(String browsers) {
		logger=LogManager.getLogger(BaseClass.class);	
		
		switch(browsers){
		case"chromeBrowser":
			ChromeOptions opt = new ChromeOptions();
			opt.addExtensions(new File("./Extentions/AdBlock.crx"));
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver=new ChromeDriver(opt);
			break;
		case"edgeBrowser":
			System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
			driver=new EdgeDriver();
			break;
		default:
			break;	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(String testName) throws Exception{
		screenShot = (TakesScreenshot)driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		File destination = new File("E:\\New folder\\inetBankingV1\\screenShots\\"+testName+".jpeg");
		FileUtils.copyFile(source, destination);
		System.out.println(testName+" :Failed ScreenShot Takened");
		
	}	
	public String fakerClass() {
		faker = new Faker();
		String email = faker.internet().safeEmailAddress();
		return email;
	}
	
			

}










