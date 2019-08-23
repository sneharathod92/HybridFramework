package com.clc.hybrid.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clc.hybrid.pageobject.LoginPage;

public class TC_Login_01 extends BaseClass{
	
	@Test
	public void LoginTest() throws IOException{
		
		LoginPage lp=new LoginPage(driver);
		lp.setuname(userN);
		logger.info("entered username");
		
		lp.setPwd(userP);
		logger.info("entered passowrd");
		
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("login test passed");
		}else{
			captureScreeshot(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
	}

}
