package com.clc.hybrid.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.clc.hybrid.utility.ReadConfig;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	public String url = rc.getApplicationUrl();
	public String userN = rc.getUserName();
	public String userP = rc.getUserPwd();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromPath());
			driver = new ChromeDriver();
		} else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getfirFoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", rc.getiepath());
			driver = new InternetExplorerDriver();
		}

		logger = Logger.getLogger("HybridFramework");
		PropertyConfigurator.configure("log4j.properties");
		driver.get(url);

		}
	
		@AfterClass
		public void tearDown() {
			driver.close();
		}
		
	
	public String randomString(){
		String randomStr=RandomStringUtils.randomAlphabetic(5);
		return randomStr;
	}
		public void captureScreeshot(WebDriver driver, String tname) throws IOException{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			File destination=new File(System.getProperty("user-dir")+"/Screenshots/"+tname+".png");
			
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");
		}
}
